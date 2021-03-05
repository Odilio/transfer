package br.com.b3.pip.gerenciarrecurso.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SituacaoMovimentacaoFinanceiraDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer numeroSituacaoMovimentacaoFinanceira;
	private String nomeSituacaoMovimentacaoFinanceira;
	private String descricaoSituacaoMovimentacaoFinanceira;
	
	public SituacaoMovimentacaoFinanceiraDTO() {
		
	}
	public SituacaoMovimentacaoFinanceiraDTO(Integer numeroSituacaoMovimentacaoFinanceira) {
		this.numeroSituacaoMovimentacaoFinanceira = numeroSituacaoMovimentacaoFinanceira;
	}
		
	public Integer getNumeroSituacaoMovimentacaoFinanceira() {
		return numeroSituacaoMovimentacaoFinanceira;
	}
	public void setNumeroSituacaoMovimentacaoFinanceira(Integer numeroSituacaoMovimentacaoFinanceira) {
		this.numeroSituacaoMovimentacaoFinanceira = numeroSituacaoMovimentacaoFinanceira;
	}
	public String getNomeSituacaoMovimentacaoFinanceira() {
		return nomeSituacaoMovimentacaoFinanceira;
	}
	public void setNomeSituacaoMovimentacaoFinanceira(String nomeSituacaoMovimentacaoFinanceira) {
		this.nomeSituacaoMovimentacaoFinanceira = nomeSituacaoMovimentacaoFinanceira;
	}
	public String getDescricaoSituacaoMovimentacaoFinanceira() {
		return descricaoSituacaoMovimentacaoFinanceira;
	}
	public void setDescricaoSituacaoMovimentacaoFinanceira(String descricaoSituacaoMovimentacaoFinanceira) {
		this.descricaoSituacaoMovimentacaoFinanceira = descricaoSituacaoMovimentacaoFinanceira;
	}
}
