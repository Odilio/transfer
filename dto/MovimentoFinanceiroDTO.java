package br.com.b3.pip.gerenciarrecurso.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MovimentoFinanceiroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer numeroMovimentoFinanceiro;
	private ContratoDTO contrato;
	private ParticipanteDTO participante;
	private Double valorTransferencia;
	private String indicadorCreditoDebito;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataHoraInicioMovimento;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dataHoraFimMovimento;
    private String tipo;
	private MotivoSituacaoMovimentacaoFinanceiraDTO motivoSituacaoMovimentacaoFinanceira;

	
	
	public MotivoSituacaoMovimentacaoFinanceiraDTO getMotivoSituacaoMovimentacaoFinanceira() {
		return motivoSituacaoMovimentacaoFinanceira;
	}
	public void setMotivoSituacaoMovimentacaoFinanceira(
			MotivoSituacaoMovimentacaoFinanceiraDTO motivoSituacaoMovimentacaoFinanceira) {
		this.motivoSituacaoMovimentacaoFinanceira = motivoSituacaoMovimentacaoFinanceira;
	}
	public Integer getNumeroMovimentoFinanceiro() {
		return numeroMovimentoFinanceiro;
	}
	public void setNumeroMovimentoFinanceiro(Integer numeroMovimentoFinanceiro) {
		this.numeroMovimentoFinanceiro = numeroMovimentoFinanceiro;
	}
	public ContratoDTO getContrato() {
		return contrato;
	}
	public void setContrato(ContratoDTO contrato) {
		this.contrato = contrato;
	}
	public ParticipanteDTO getParticipante() {
		return participante;
	}
	public void setParticipante(ParticipanteDTO participante) {
		this.participante = participante;
	}
	public Double getValorTransferencia() {
		return valorTransferencia;
	}
	public void setValorTransferencia(Double valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}
	public String getIndicadorCreditoDebito() {
		return indicadorCreditoDebito;
	}
	public void setIndicadorCreditoDebito(String indicadorCreditoDebito) {
		this.indicadorCreditoDebito = indicadorCreditoDebito;
	}
	public Date getDataHoraInicioMovimento() {
		return dataHoraInicioMovimento;
	}
	public void setDataHoraInicioMovimento(Date dataHoraInicioMovimento) {
		this.dataHoraInicioMovimento = dataHoraInicioMovimento;
	}
	public Date getDataHoraFimMovimento() {
		return dataHoraFimMovimento;
	}
	public void setDataHoraFimMovimento(Date dataHoraFimMovimento) {
		this.dataHoraFimMovimento = dataHoraFimMovimento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
}
