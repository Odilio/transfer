package br.com.b3.pip.gerenciarrecurso.dto;

import java.io.Serializable;

public class CriacaoMovimentoFinanceiroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String mensagem;

	public CriacaoMovimentoFinanceiroDTO() {}
	
	public CriacaoMovimentoFinanceiroDTO(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
