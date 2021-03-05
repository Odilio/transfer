package br.com.b3.pip.gerenciarrecurso.exceptions;

public class ParametroObrigatorioException extends Exception {
	private static final long serialVersionUID = 1L;

	private String mensagem;
	
	public ParametroObrigatorioException(String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
}
