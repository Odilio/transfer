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
@Table(name = "TPIPMOVIMENTO_FINANCEIRO")
public class MovimentoFinanceiroDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="S_TPIPMOVIMENTO_FINANCEIRO")
	@SequenceGenerator(name="S_TPIPMOVIMENTO_FINANCEIRO", sequenceName = "S_TPIPMOVIMENTO_FINANCEIRO", allocationSize = 1)
	@Column(name = "NUM_MOVIMENTO_FINANCEIRO")
    private Integer numeroMovimentoFinanceiro;
	
	@ManyToOne
	@JoinColumn(name = "NUM_CONTRATO")
	private ContratoDO contrato;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PARTICIPANTE")
	private ParticipanteDO participante;
	
	@Column(name = "VAL_TRANSFERENCIA")
	private Double valorTransferencia;
	
	@Column(name = "IND_CREDITO_DEBITO")
	private String indicadorCreditoDebito;
	
	@Column(name = "DTHR_INICIO_MOVIMENTO")
	private LocalDateTime dataHoraInicioMovimento;
	
	@Column(name = "DTHR_FIM_MOVIMENTO")
    private LocalDateTime dataHoraFimMovimento;
	
	@Column(name = "NUM_MOTIVO_SITUACAO_MOVIMENTACAO_FINANCEIRA", updatable = false)
	private Long motivoSituacaoMovimentacaoFinanceira;
	
	
	public Long getMotivoSituacaoMovimentacaoFinanceira() {
		return motivoSituacaoMovimentacaoFinanceira;
	}

	public void setMotivoSituacaoMovimentacaoFinanceira(
			Long motivoSituacaoMovimentacaoFinanceira) {
		this.motivoSituacaoMovimentacaoFinanceira = motivoSituacaoMovimentacaoFinanceira;
	}

	public MovimentoFinanceiroDO() {
	}

	public Integer getNumeroMovimentoFinanceiro() {
		return numeroMovimentoFinanceiro;
	}

	public void setNumeroMovimentoFinanceiro(Integer numeroMovimentoFinanceiro) {
		this.numeroMovimentoFinanceiro = numeroMovimentoFinanceiro;
	}

	public ContratoDO getContrato() {
		return contrato;
	}

	public void setContrato(ContratoDO contrato) {
		this.contrato = contrato;
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

	public LocalDateTime getDataHoraInicioMovimento() {
		return dataHoraInicioMovimento;
	}

	public void setDataHoraInicioMovimento(LocalDateTime dataHoraInicioMovimento) {
		this.dataHoraInicioMovimento = dataHoraInicioMovimento;
	}

	public LocalDateTime getDataHoraFimMovimento() {
		return dataHoraFimMovimento;
	}

	public void setDataHoraFimMovimento(LocalDateTime dataHoraFimMovimento) {
		this.dataHoraFimMovimento = dataHoraFimMovimento;
	}

	public ParticipanteDO getParticipante() {
		return participante;
	}

	public void setParticipante(ParticipanteDO participante) {
		this.participante = participante;
	}
	
}