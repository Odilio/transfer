package br.com.b3.pip.gerenciarrecurso.model;

public class FrontCredito {

	private Integer codigoParticipante;

	private String codigoContrato; 
	
	private Double valor;
	
	public Integer getCodigoParticipante() {
		return codigoParticipante;
	}
	
	public void setCodigoParticipante(Integer codigoParticipante) {
		this.codigoParticipante = codigoParticipante;
	}
	
	public String getContrato() {
		return codigoContrato;
	}
	
	public void setContrato(String codigoContrato) {
		this.codigoContrato = codigoContrato;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
