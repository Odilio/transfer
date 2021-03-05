package br.com.b3.pip.gerenciarrecurso.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StatusMensagemContrato {

	public static final Logger logger = LoggerFactory.getLogger(StatusMensagemContrato.class);
	private static ObjectMapper mapper = new ObjectMapper();
	
	private Integer numeroParticipante;
	
	private Integer numeroContrato;
	
	private Integer numeroOperacao;
	
	private Integer numeroOferta;
	
	private Boolean isOk;
	
	private Integer numeroMovimentoFinanceiro;
	
	private String codigoContaPI;
	
	private Double valor;
	
	private Long numeroMotivoSituacaoMovimentacaoFinanceira;

	public StatusMensagemContrato() {
		super();
	}
	
	public StatusMensagemContrato(Integer numeroParticipante, Integer numeroContrato, Integer numeroMovimentoFinanceiro,
			String codigoContaPI, Double valor) {
		super();
		this.numeroParticipante = numeroParticipante;
		this.numeroContrato = numeroContrato;
		this.numeroMovimentoFinanceiro = numeroMovimentoFinanceiro;
		this.codigoContaPI = codigoContaPI;
		this.valor = valor;
	}
	
	public StatusMensagemContrato(Integer numeroParticipante, Integer numeroContrato, Integer numeroMovimentoFinanceiro,
			String codigoContaPI, Double valor, Long motivoSituacaoMovimentacaoFinanceira) {
		super();
		this.numeroParticipante = numeroParticipante;
		this.numeroContrato = numeroContrato;
		this.numeroMovimentoFinanceiro = numeroMovimentoFinanceiro;
		this.codigoContaPI = codigoContaPI;
		this.valor = valor;
		this.numeroMotivoSituacaoMovimentacaoFinanceira = motivoSituacaoMovimentacaoFinanceira;
	}
	
	

	public StatusMensagemContrato(Integer numeroParticipante, Integer numeroContrato, Integer numeroOperacao,
			Integer numeroOferta, Boolean isOk, Integer numeroMovimentoFinanceiro, String codigoContaPI, Double valor) {
		super();
		this.numeroParticipante = numeroParticipante;
		this.numeroContrato = numeroContrato;
		this.numeroOperacao = numeroOperacao;
		this.numeroOferta = numeroOferta;
		this.isOk = isOk;
		this.numeroMovimentoFinanceiro = numeroMovimentoFinanceiro;
		this.codigoContaPI = codigoContaPI;
		this.valor = valor;
	}

	public static String convertToString(StatusMensagemContrato statusMensagemContrato) {
		String result = null;
		try {
			result = mapper.writeValueAsString(statusMensagemContrato);
		} catch (JsonProcessingException e) {
			logger.error("Error converting CashSendDto object to String");
		}
		return result;
	}

	public static StatusMensagemContrato convertToObject(String mensagem) {

		StatusMensagemContrato statusMensagemContrato = null;
		try {
			statusMensagemContrato =  (StatusMensagemContrato) mapper.readValue(mensagem, StatusMensagemContrato.class);
		} catch (Exception e) {
			logger.error("Error converting String to CashSendDto object");
		}
		return statusMensagemContrato;
	}

	public Integer getNumeroParticipante() {
		return numeroParticipante;
	}

	public void setNumeroParticipante(Integer numeroParticipante) {
		this.numeroParticipante = numeroParticipante;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(Integer numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public Integer getNumeroMovimentoFinanceiro() {
		return numeroMovimentoFinanceiro;
	}

	public void setNumeroMovimentoFinanceiro(Integer numeroMovimentoFinanceiro) {
		this.numeroMovimentoFinanceiro = numeroMovimentoFinanceiro;
	}

	public String getCodigoContaPI() {
		return codigoContaPI;
	}

	public void setCodigoContaPI(String codigoContaPI) {
		this.codigoContaPI = codigoContaPI;
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

	public Boolean getIsOk() {
		return isOk;
	}

	public void setIsOk(Boolean isOk) {
		this.isOk = isOk;
	}

	public Long getNumeroMotivoSituacaoMovimentacaoFinanceira() {
		return numeroMotivoSituacaoMovimentacaoFinanceira;
	}

	public void setNumeroMotivoSituacaoMovimentacaoFinanceira(Long motivoSituacaoMovimentacaoFinanceira) {
		this.numeroMotivoSituacaoMovimentacaoFinanceira = motivoSituacaoMovimentacaoFinanceira;
	}

	
}
