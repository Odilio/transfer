package br.com.b3.pip.gerenciarrecurso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TPIPMOTIVO_SITUACAO_CONTRATO")
public class MotivoSituacaoContratoDO {

	public MotivoSituacaoContratoDO() {
	}

	@Id
	@Column(name = "NUM_MOTIVO_SITUACAO_CONTRATO")
	private Integer numeroMotivoSituacaoContrato;
	
	@ManyToOne
	@JoinColumn(name = "NUM_SITUACAO_CONTRATO")
	private SituacaoContratoDO situacaoContrato;

	@Column(name = "NOME_MOTIVO_SITUACAO_CONTRATO")
	private String nomeMotivoSituacaoContrato;
	
	@Column(name = "DESC_MOTIVO_SITUACAO_CONTRATO")
	private String descricaoMotivoSituacaoContrato;

	public Integer getNumeroMotivoSituacaoContrato() {
		return numeroMotivoSituacaoContrato;
	}

	public void setNumeroMotivoSituacaoContrato(Integer numeroMotivoSituacaoContrato) {
		this.numeroMotivoSituacaoContrato = numeroMotivoSituacaoContrato;
	}

	public SituacaoContratoDO getSituacaoContrato() {
		return situacaoContrato;
	}

	public void setSituacaoContrato(SituacaoContratoDO situacaoContrato) {
		this.situacaoContrato = situacaoContrato;
	}

	public String getNomeMotivoSituacaoContrato() {
		return nomeMotivoSituacaoContrato;
	}

	public void setNomeMotivoSituacaoContrato(String nomeMotivoSituacaoContrato) {
		this.nomeMotivoSituacaoContrato = nomeMotivoSituacaoContrato;
	}

	public String getDescricaoMotivoSituacaoContrato() {
		return descricaoMotivoSituacaoContrato;
	}

	public void setDescricaoMotivoSituacaoContrato(String descricaoMotivoSituacaoContrato) {
		this.descricaoMotivoSituacaoContrato = descricaoMotivoSituacaoContrato;
	}
}
