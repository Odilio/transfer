package br.com.b3.pip.gerenciarrecurso.core.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.b3.pip.gerenciarrecurso.dto.ClienteJdpiDTO;
import br.com.b3.pip.gerenciarrecurso.model.TokenJDPI;
import br.com.b3.pip.gerenciarrecurso.repository.TokenJDPIRepository;

@Service
public class AuthJDServiceImpl {

	@Value("${jdpi.endpoint}")
	private String endpoint;
	
	
	@Autowired
	private TokenJDPIRepository repository;
	
	public static final Logger logger = LoggerFactory.getLogger(AuthJDServiceImpl.class);

	
	public ResponseEntity<TokenJDPI> getToken(ClienteJdpiDTO clientJDPI) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			Gson gson = new  Gson();
			restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
	
			HttpEntity<MultiValueMap<String, String>> request = setHeadersBody(clientJDPI);

			byte[] responseBytes = restTemplate.exchange(endpoint + "/jdpi/connect/token", HttpMethod.POST, request, byte[].class).getBody();

			TokenJDPI token = converteBytesToTokenJDPI(gson, responseBytes);
			
			TokenJDPI exists = repository.findByScope(token.getScope());
			
			if (exists == null ) {
				repository.save(token);
				return new ResponseEntity<TokenJDPI>(token, HttpStatus.OK);
			}else {
				if ( isTokenExpired(exists.getExpiresIn())) {
					repository.delete(exists);
					repository.save(token);
					return new ResponseEntity<TokenJDPI>(token, HttpStatus.OK);
				}else
				return ResponseEntity.accepted().body(exists);
			}
			
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
			return new ResponseEntity<TokenJDPI>(HttpStatus.UNAUTHORIZED);
		} catch (RestClientException e) {
			e.printStackTrace();
			return new ResponseEntity<TokenJDPI>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<TokenJDPI>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		
		
	}

	private TokenJDPI converteBytesToTokenJDPI(Gson gson, byte[] responseBytes) throws IOException {
		GZIPInputStream gzip = new GZIPInputStream(new ByteArrayInputStream(responseBytes));

		// convert the stream to string
		StringWriter writer = new StringWriter();
		IOUtils.copy(gzip, writer, "UTF-8");
		String retorno = writer.toString();
					
		JsonObject json = gson.fromJson(retorno, JsonObject.class);
					
		TokenJDPI token = new TokenJDPI();
				token.setAccessToken(json.get("access_token").getAsString());
				token.setExpiresIn(json.get("expires_in").getAsLong());
				token.setScope(json.get("scope").getAsString());
				token.setTokenType(json.get("token_type").getAsString());
				token.setDataHoraCriacao(LocalDateTime.now());
		return token;
	}

	private HttpEntity<MultiValueMap<String, String>> setHeadersBody(ClienteJdpiDTO clientJDPI) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Host", "JDPI04358798homl.jdPSTI.rtm");
		headers.add("Content-Type", "application/x-www-form-urlencoded");
		headers.add("Accept-Encoding", "gzip");
		headers.add("Accept", "*/*");
		
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("client_id", clientJDPI.getClientId());
		map.add("client_secret", clientJDPI.getClientSecret());
		map.add("grant_type", clientJDPI.getGrantType());
		map.add("scope", clientJDPI.getScope());

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		return request;
	}

	public Boolean isTokenExpired(long token) {
		LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(token, 0, ZoneOffset.UTC);
	return localDateTime.isBefore(LocalDateTime.now());
	}
	
	
	public List<TokenJDPI> retornaTokens() {
		List<TokenJDPI> msg =repository.findAll();
		return msg;
	}
}