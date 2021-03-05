package br.com.b3.pip.gerenciarrecurso.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TPIPTOKEN_JD")
public class TokenJDPI implements Serializable {

	private static final long serialVersionUID = 1L;

	public TokenJDPI() {
	}

	@Id
	@Column(name = "COD_TOKEN_ACESSO")
    private String accessToken;
	
	@Column(name = "NUM_EXPIRACAO")
    private Long expiresIn;
	
	@Column(name = "COD_TIPO_TOKEN")
    private String tokenType;
	
	@Column(name = "NOME_ESCOPO_TOKEN")
    private String scope;
	
	@Column(name = "DTHR_CRIACAO")
	private LocalDateTime dataHoraCriacao; 

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public LocalDateTime getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
	}
	
	
	
}