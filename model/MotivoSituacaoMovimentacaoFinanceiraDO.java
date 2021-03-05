package br.com.b3.pip.gerenciarrecurso.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TPIPMOTIVO_SITUACAO_MOVIMENTACAO_FINANCEIRA")
public class MotivoSituacaoMovimentacaoFinanceiraDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUM_MOTIVO_SITUACAO_MOVIMENTACAO_FINANCEIRA")
	private Long numeroMotivoSituacaoMovimentacaoFinanceira;
	
	@Column(name = "NOME_MOTIVO_SITUACAO_MOVIMENTACAO_FINANCEIRA")
	private String nomeMotivoSituacaoMovimentacaoFinanceira;
	
	@Column(name = "DESC_MOTIVO_SITUACAO_MOVIMENTACAO_FINANCEIRA")
	private String descricaoMotivoSituacaoMovimentacaoFinanceira;
	
	@Column(name = "NUM_SITUACAO_MOVIMENTACAO_FINANCEIRA", insertable = false, updatable = false)
	private Long situacaoMovimentacaoFinanceira;

	public Long getNumeroMotivoSituacaoMovimentacaoFinanceira() {
		return numeroMotivoSituacaoMovimentacaoFinanceira;
	}

	public void setNumeroMotivoSituacaoMovimentacaoFinanceira(Long numeroMotivoSituacaoMovimentacaoFinanceira) {
		this.numeroMotivoSituacaoMovimentacaoFinanceira = numeroMotivoSituacaoMovimentacaoFinanceira;
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

	public Long getSituacaoMovimentacaoFinanceira() {
		return situacaoMovimentacaoFinanceira;
	}

	public void setSituacaoMovimentacaoFinanceira(Long situacaoMovimentacaoFinanceira) {
		this.situacaoMovimentacaoFinanceira = situacaoMovimentacaoFinanceira;
	}

	
}