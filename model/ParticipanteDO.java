package br.com.b3.pip.gerenciarrecurso.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TPIPPARTICIPANTE")
@SequenceGenerator(name = "S_TPIPPARTICIPANTE", sequenceName = "S_TPIPPARTICIPANTE", initialValue = 1, allocationSize = 1)
public class ParticipanteDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NUM_PARTICIPANTE")
    private Integer numeroParticipante;
	
	@Column(name = "NUM_CATEGORIA_PARTICIPANTE")
	private Integer numeroCategoriaParticipante;
	
	@Column(name = "NOME_PARTICIPANTE")
	private String nomeParticipante;
	
	@Column(name = "COD_CONTA_SELIC")
	private String codigoContaSelic;
	
	@Column(name = "COD_CONTA_PI")
	private String codigoContaPi;
	
	@Column(name = "COD_DOCUMENTO")
	private String codigoDocumento;
	
	@Column(name = "NUM_SITUACAO_PARTICIPANTE")
    private Integer numeroSituacaoParticipante;
	
	@Column(name = "COD_PARTICIPANTE")
	private Integer codigoParticipante;
	
	public ParticipanteDO() {
	}

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