package br.com.b3.pip.gerenciarrecurso.model;

import java.time.LocalDateTime;

public class FrontMovimentoFinanceiro {

	private Integer numeroMovimentoFinanceiro;

	private String codigoContrato;
	
	private String motivoSituacaoContrato;

	private Integer numeroParticipante;

	private String valorTransferencia;

	private String indicadorCreditoDebito;

	private String dataHoraInicioMovimento;

	private LocalDateTime dataHoraInicioMovimentoInter;

	public FrontMovimentoFinanceiro() {
	}

	public Integer getNumeroMovimentoFinanceiro() {
		return numeroMovimentoFinanceiro;
	}

	public void setNumeroMovimentoFinanceiro(Integer numeroMovimentoFinanceiro) {
		this.numeroMovimentoFinanceiro = numeroMovimentoFinanceiro;
	}

	public String getCodigoContrato() {
		return codigoContrato;
	}

	public void setCodigoContrato(String codigoContrato) {
		this.codigoContrato = codigoContrato;
	}

	public Integer getNumeroParticipante() {
		return numeroParticipante;
	}

	public void setNumeroParticipante(Integer numeroParticipante) {
		this.numeroParticipante = numeroParticipante;
	}

	public String getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(String valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	public String getIndicadorCreditoDebito() {
		return indicadorCreditoDebito;
	}

	public void setIndicadorCreditoDebito(String indicadorCreditoDebito) {
		this.indicadorCreditoDebito = indicadorCreditoDebito;
	}

	public String getDataHoraInicioMovimento() {
		return dataHoraInicioMovimento;
	}

	public void setDataHoraInicioMovimento(String dataHoraInicioMovimento) {
		this.dataHoraInicioMovimento = dataHoraInicioMovimento;
	}

	public LocalDateTime getDataHoraInicioMovimentoInter() {
		return dataHoraInicioMovimentoInter;
	}

	public void setDataHoraInicioMovimentoInter(LocalDateTime dataHoraInicioMovimentoInter) {
		this.dataHoraInicioMovimentoInter = dataHoraInicioMovimentoInter;
	}

	public String getMotivoSituacaoContrato() {
		return motivoSituacaoContrato;
	}

	public void setMotivoSituacaoContrato(String motivoSituacaoContrato) {
		this.motivoSituacaoContrato = motivoSituacaoContrato;
	}

}