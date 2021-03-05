package br.com.b3.pip.gerenciarrecurso.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MotivoSituacaoMovimentacaoFinanceiraDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long numeroMotivoSituacaoMovimentacaoFinanceira;
	private SituacaoMovimentacaoFinanceiraDTO situacaoMovimentacaoFinanceira;
	private String nomeMotivoSituacaoMovimentacaoFinanceira;
	private String descricaoMotivoSituacaoMovimentacaoFinanceira;
	
	public Long getNumeroMotivoSituacaoMovimentacaoFinanceira() {
		return numeroMotivoSituacaoMovimentacaoFinanceira;
	}
	public void setNumeroMotivoSituacaoMovimentacaoFinanceira(Long numeroMotivoSituacaoMovimentacaoFinanceira) {
		this.numeroMotivoSituacaoMovimentacaoFinanceira = numeroMotivoSituacaoMovimentacaoFinanceira;
	}
	public SituacaoMovimentacaoFinanceiraDTO getSituacaoMovimentacaoFinanceira() {
		return situacaoMovimentacaoFinanceira;
	}
	public void setSituacaoMovimentacaoFinanceira(SituacaoMovimentacaoFinanceiraDTO situacaoMovimentacaoFinanceira) {
		this.situacaoMovimentacaoFinanceira = situacaoMovimentacaoFinanceira;
	}
	public String getNomeMotivoSituacaoMovimentacaoFinanceira() {
		return nomeMotivoSituacaoMovimentacaoFinanceira;
	}
	public void setNomeMotivoSituacaoMovimentacaoFinanceira(String nomeMotivoSituacaoMovimentacaoFinanceira) {
		this.nomeMotivoSituacaoMovimentacaoFinanceira = nomeMotivoSituacaoMovimentacaoFinanceira;
	}
	public String getDescricaoMotivoSituacaoMovimentacaoFinanceira() {
		return descricaoMotivoSituacaoMovimentacaoFinanceira;
	}
	public void setDescricaoMotivoSituacaoMovimentacaoFinanceira(String descricaoMotivoSituacaoMovimentacaoFinanceira) {
		this.descricaoMotivoSituacaoMovimentacaoFinanceira = descricaoMotivoSituacaoMovimentacaoFinanceira;
	}
}
