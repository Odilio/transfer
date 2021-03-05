package br.com.b3.pip.gerenciarrecurso.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TPIPCONTRATO")
public class ContratoDO implements Serializable {

	private static final long serialVersionUID = 1L;

	public ContratoDO() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="S_TPIPCONTRATO")
	@SequenceGenerator(name="S_TPIPCONTRATO", sequenceName = "S_TPIPCONTRATO", allocationSize = 1)
	@Column(name = "NUM_CONTRATO")
    private Integer numeroContrato;
	
	@Column(name = "NUM_OPERACAO")
    private Integer numeroOperacao;
	
	@Column(name = "NUM_OFERTA")
    private Integer numeroOferta;
	
	@ManyToOne
	@JoinColumn(name = "NUM_MOTIVO_SITUACAO_CONTRATO")
    private MotivoSituacaoContratoDO motivoSituacaoContrato;
	
	@Column(name = "COD_CONTRATO")
	private String codigoContrato;
	
	@Column(name = "DTHR_INCLUSAO")
	private LocalDateTime dataHoraInclusao;
	
	@Column(name = "DTHR_EXPIRACAO")
	private LocalDateTime dataHoraExpiracao;
	
	@Column(name = "DTHR_LIQUIDACAO_IDA")
	private LocalDateTime dataHoraLiquidacaoIda;
	
	@Column(name = "DTHR_LIQUIDACAO_VOLTA")
	private LocalDateTime dataHoraLiquidacaoVolta;

	public Integer getNumeroContrato() {
		return numeroContrato;
	}

	public Integer getNumeroOperacao() {
		return numeroOperacao;
	}

	public void setNumeroOperacao(Integer numeroOperacao) {
		this.numeroOperacao = numeroOperacao;
	}

	public Integer getNumeroOferta() {
		return numeroOferta;
	}

	public void setNumeroOferta(Integer numeroOferta) {
		this.numeroOferta = numeroOferta;
	}

	public MotivoSituacaoContratoDO getMotivoSituacaoContrato() {
		return motivoSituacaoContrato;
	}

	public void setMotivoSituacaoContrato(MotivoSituacaoContratoDO motivoSituacaoContrato) {
		this.motivoSituacaoContrato = motivoSituacaoContrato;
	}

	public void setNumeroContrato(Integer numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public String getCodigoContrato() {
		return codigoContrato;
	}

	public void setCodigoContrato(String codigoContrato) {
		this.codigoContrato = codigoContrato;
	}

	public LocalDateTime getDataHoraInclusao() {
		return dataHoraInclusao;
	}

	public void setDataHoraInclusao(LocalDateTime dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}

	public LocalDateTime getDataHoraExpiracao() {
		return dataHoraExpiracao;
	}

	public void setDataHoraExpiracao(LocalDateTime dataHoraExpiracao) {
		this.dataHoraExpiracao = dataHoraExpiracao;
	}

	public LocalDateTime getDataHoraLiquidacaoIda() {
		return dataHoraLiquidacaoIda;
	}

	public void setDataHoraLiquidacaoIda(LocalDateTime dataHoraLiquidacaoIda) {
		this.dataHoraLiquidacaoIda = dataHoraLiquidacaoIda;
	}

	public LocalDateTime getDataHoraLiquidacaoVolta() {
		return dataHoraLiquidacaoVolta;
	}

	public void setDataHoraLiquidacaoVolta(LocalDateTime dataHoraLiquidacaoVolta) {
		this.dataHoraLiquidacaoVolta = dataHoraLiquidacaoVolta;
	}
	
}