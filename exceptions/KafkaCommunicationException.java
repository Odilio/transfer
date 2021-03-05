package br.com.b3.pip.gerenciarrecurso.exceptions;

public class KafkaCommunicationException extends Exception {

	private static final long serialVersionUID = 1L;

	public KafkaCommunicationException(String message, Exception e) {
        super(message, e);
    }
}
