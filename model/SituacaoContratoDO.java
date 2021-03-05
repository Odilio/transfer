package br.com.b3.pip.gerenciarrecurso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TPIPSITUACAO_CONTRATO")
public class SituacaoContratoDO {


	public SituacaoContratoDO() {
	}

	@Id
	@Column(name = "NUM_SITUACAO_CONTRATO")
	private Integer numeroSituacaoContrato;

	@Column(name = "NOME_SITUACAO_CONTRATO")
	private String nomeSituacaoContrato;
	
	@Column(name = "DESC_SITUACAO_CONTRATO")
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
