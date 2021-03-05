package br.com.b3.pip.gerenciarrecurso.dto;

import java.io.Serializable;

public class SituacaoContratoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer numeroSituacaoContrato;
	private String nomeSituacaoContrato;
	private String descricaoSituacaoContrato;
	
	public Integer getNumeroSituacaoContrato() {
		return numeroSituacaoContrato;
	}
	public void setNumeroSituacaoContrato(Integer numeroSituacaoContrato) {
		this.numeroSituacaoContrato = numeroSituacaoContrato;
	}
	public String getNomeSituacaoContrato() {
		return nomeSituacaoContrato;
	}
	public void setNomeSituacaoContrato(String nomeSituacaoContrato) {
		this.nomeSituacaoContrato = nomeSituacaoContrato;
	}
	public String getDescricaoSituacaoContrato() {
		return descricaoSituacaoContrato;
	}
	public void setDescricaoSituacaoContrato(String descricaoSituacaoContrato) {
		this.descricaoSituacaoContrato = descricaoSituacaoContrato;
	}
}
