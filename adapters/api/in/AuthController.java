package br.com.b3.pip.gerenciarrecurso.adapters.api.in;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.b3.pip.gerenciarrecurso.core.impl.AuthJDServiceImpl;
import br.com.b3.pip.gerenciarrecurso.dto.ClienteJdpiDTO;

@RestController
@RequestMapping("auth")
public class AuthController {
	
	@Autowired
	private AuthJDServiceImpl service;
	
	public static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@PostMapping
	public ResponseEntity<Object> gerarTokenAutenticacao(@RequestBody ClienteJdpiDTO parametros) {
		logger.info("Iniciando o método Autenticar");
		try {
			return new ResponseEntity<>(this.service.getToken(parametros), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Erro interno do sistema", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<Object> getToken() {
		logger.info("Iniciando o método retornar tokens");
		
		try {
			return new ResponseEntity<>(this.service.retornaTokens(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro interto do sistema", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}