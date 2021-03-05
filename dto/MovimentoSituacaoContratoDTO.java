package br.com.b3.pip.gerenciarrecurso.dto;

import java.io.Serializable;

public class MovimentoSituacaoContratoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer numeroMotivoSituacaoContrato;
	private SituacaoContratoDTO situacaoContrato;
	private String nomeMotivoSituacaoContrato;
	private String descricaoMotivoSituacaoContrato;
	
	public Integer getNumeroMotivoSituacaoContrato() {
		return numeroMotivoSituacaoContrato;
	}
	public void setNumeroMotivoSituacaoContrato(Integer numeroMotivoSituacaoContrato) {
		this.numeroMotivoSituacaoContrato = numeroMotivoSituacaoContrato;
	}
	public SituacaoContratoDTO getSituacaoContrato() {
		return situacaoContrato;
	}
	public void setSituacaoContrato(SituacaoContratoDTO situacaoContrato) {
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
