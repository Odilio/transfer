package br.com.b3.pip.gerenciarrecurso.dto;

import java.io.Serializable;

public class ParticipanteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer numeroParticipante;
	private Integer numeroCategoriaParticipante;
	private String nomeParticipante;
	private String codigoContaSelic;
	private String codigoContaPi;
	private String codigoDocumento;
    private Integer numeroSituacaoParticipante;
	private Integer codigoParticipante;
	
	public Integer getNumeroParticipante() {
		return numeroParticipante;
	}
	public void setNumeroParticipante(Integer numeroParticipante) {
		this.numeroParticipante = numeroParticipante;
	}
	public Integer getNumeroCategoriaParticipante() {
		return numeroCategoriaParticipante;
	}
	public void setNumeroCategoriaParticipante(Integer numeroCategoriaParticipante) {
		this.numeroCategoriaParticipante = numeroCategoriaParticipante;
	}
	public String getNomeParticipante() {
		return nomeParticipante;
	}
	public void setNomeParticipante(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
	}
	public String getCodigoContaSelic() {
		return codigoContaSelic;
	}
	public void setCodigoContaSelic(String codigoContaSelic) {
		this.codigoContaSelic = codigoContaSelic;
	}
	public String getCodigoContaPi() {
		return codigoContaPi;
	}
	public void setCodigoContaPi(String codigoContaPi) {
		this.codigoContaPi = codigoContaPi;
	}
	public String getCodigoDocumento() {
		return codigoDocumento;
	}
	public void setCodigoDocumento(String codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}
	public Integer getNumeroSituacaoParticipante() {
		return numeroSituacaoParticipante;
	}
	public void setNumeroSituacaoParticipante(Integer numeroSituacaoParticipante) {
		this.numeroSituacaoParticipante = numeroSituacaoParticipante;
	}
	public Integer getCodigoParticipante() {
		return codigoParticipante;
	}
	public void setCodigoParticipante(Integer codigoParticipante) {
		this.codigoParticipante = codigoParticipante;
	}
}
