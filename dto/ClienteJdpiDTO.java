package br.com.b3.pip.gerenciarrecurso.dto;

import java.io.Serializable;

public class ClienteJdpiDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public ClienteJdpiDTO() {
	}

	private String clientId;
	
	private String clientSecret;
	
	private String grantType;
	
	private String scope;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	
	
	
}