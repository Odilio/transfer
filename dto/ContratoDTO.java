package br.com.b3.pip.gerenciarrecurso.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ContratoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer numeroContrato;
    private Integer numeroOperacao;
    private Integer numeroOferta;
    private MotivoSituacaoContratoDTO motivoSituacaoContrato;
	private String codigoContrato;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataHoraInclusao;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataHoraExpiracao;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataHoraLiquidacaoIda;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataHoraLiquidacaoVolta;
	
	public Integer getNumeroContrato() {
		return numeroContrato;
	}
	public void setNumeroContrato(Integer numeroContrato) {
		this.numeroContrato = numeroContrato;
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
	public MotivoSituacaoContratoDTO getMotivoSituacaoContrato() {
		return motivoSituacaoContrato;
	}
	public void setMotivoSituacaoContrato(MotivoSituacaoContratoDTO motivoSituacaoContrato) {
		this.motivoSituacaoContrato = motivoSituacaoContrato;
	}
	public String getCodigoContrato() {
		return codigoContrato;
	}
	public void setCodigoContrato(String codigoContrato) {
		this.codigoContrato = codigoContrato;
	}
	public Date getDataHoraInclusao() {
		return dataHoraInclusao;
	}
	public void setDataHoraInclusao(Date dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}
	public Date getDataHoraExpiracao() {
		return dataHoraExpiracao;
	}
	public void setDataHoraExpiracao(Date dataHoraExpiracao) {
		this.dataHoraExpiracao = dataHoraExpiracao;
	}
	public Date getDataHoraLiquidacaoIda() {
		return dataHoraLiquidacaoIda;
	}
	public void setDataHoraLiquidacaoIda(Date dataHoraLiquidacaoIda) {
		this.dataHoraLiquidacaoIda = dataHoraLiquidacaoIda;
	}
	public Date getDataHoraLiquidacaoVolta() {
		return dataHoraLiquidacaoVolta;
	}
	public void setDataHoraLiquidacaoVolta(Date dataHoraLiquidacaoVolta) {
		this.dataHoraLiquidacaoVolta = dataHoraLiquidacaoVolta;
	}
}
