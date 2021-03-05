package br.com.b3.pip.gerenciarrecurso.core.impl;

import org.springframework.stereotype.Service;

import br.com.b3.pip.gerenciarrecurso.adapters.messagebrokers.kafka.producer.ReceberTransferenciaDoadorProducer;
import br.com.b3.pip.gerenciarrecurso.core.ContratoService;
import br.com.b3.pip.gerenciarrecurso.core.GerenciarRecursoService;
import br.com.b3.pip.gerenciarrecurso.core.MovimentoFinanceiroService;
import br.com.b3.pip.gerenciarrecurso.core.ParticipanteService;
import br.com.b3.pip.gerenciarrecurso.model.ContratoDO;
import br.com.b3.pip.gerenciarrecurso.model.MovimentoFinanceiroDO;
import br.com.b3.pip.gerenciarrecurso.model.ParticipanteDO;
import br.com.b3.pip.gerenciarrecurso.model.StatusMensagemContrato;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class GerenciarRecursoServiceImpl implements GerenciarRecursoService {

	@Autowired
	private MovimentoFinanceiroService movimentoFinanceiroService;

	@Autowired
	private ParticipanteService participanteService;
	
	@Autowired
	private ContratoService contratoService;

	@Autowired
	private ReceberTransferenciaDoadorProducer producer;
	
	
	public static final Logger logger = LoggerFactory.getLogger(GerenciarRecursoServiceImpl.class);
	public static final String DEBITO = "D";
	public static final String CREDITO = "C";
	
	public void receberRecursos(StatusMensagemContrato statusMensagemContrato) {
		MovimentoFinanceiroDO movimentoFinanceiro = prepararMovimentoFinanceiro(statusMensagemContrato);
		statusMensagemContrato.setNumeroMovimentoFinanceiro(salvar(movimentoFinanceiro));
		enviarKafkaValidarContrato(statusMensagemContrato);
	}

	private MovimentoFinanceiroDO prepararMovimentoFinanceiro(StatusMensagemContrato statusMensagemContrato) {
		ParticipanteDO participante = participanteService.findById(statusMensagemContrato.getNumeroParticipante());
		ContratoDO contrato = contratoService.findById(statusMensagemContrato.getNumeroContrato());
		if(participante == null) {
			logger.error("Participante " + statusMensagemContrato.getNumeroParticipante() + " nao encontrado");
		}
		if(contrato == null) {
			logger.error("Contrato " + statusMensagemContrato.getNumeroContrato() + " nao encontrado");
		}
		
		
		MovimentoFinanceiroDO movimentoFinanceiro = new MovimentoFinanceiroDO();
		movimentoFinanceiro.setContrato(contrato);
		movimentoFinanceiro.setParticipante(participante);
		movimentoFinanceiro.setValorTransferencia(statusMensagemContrato.getValor());
		movimentoFinanceiro.setIndicadorCreditoDebito(validarCreditoDebito(statusMensagemContrato.getValor()));
		LocalDateTime agora = LocalDateTime.now();
		movimentoFinanceiro.setDataHoraInicioMovimento(agora);
		if(CREDITO.equals(movimentoFinanceiro.getIndicadorCreditoDebito()))
			movimentoFinanceiro.setDataHoraFimMovimento(agora);
		movimentoFinanceiro.setMotivoSituacaoMovimentacaoFinanceira(statusMensagemContrato.getNumeroMotivoSituacaoMovimentacaoFinanceira());
		return movimentoFinanceiro;
	}

	private Integer salvar(MovimentoFinanceiroDO movimentoFinanceiro) {
		try {
			movimentoFinanceiro = movimentoFinanceiroService.save(movimentoFinanceiro);
		} catch (Exception e) {
			logger.error("Contrato: " + movimentoFinanceiro.getContrato().getNumeroContrato() + " - Falha ao salvar movimento financeiro: " + e.getMessage() + ")");
		}
		return movimentoFinanceiro.getNumeroMovimentoFinanceiro();
	}

	private String validarCreditoDebito(Double valor) {
		if(valor >= 0) {
			return CREDITO;
		} else {
			return DEBITO;
		}
	}
	
	private void enviarKafkaValidarContrato(StatusMensagemContrato statusMensagemContrato) {
		try {
			producer.sendWithRetry(StatusMensagemContrato.convertToString(statusMensagemContrato));
		} catch (Exception e) {
			logger.error(statusMensagemContrato.getNumeroMovimentoFinanceiro() + " - Falha ao enviar kafka para ReceberTransferenciaDoadorProducer: " + e.getMessage());
		}
	}
	
	public void respostaTransferenciaDevolucao(StatusMensagemContrato statusMensagemContrato) {
		MovimentoFinanceiroDO movimentoFinanceiro = prepararMovimentoFinanceiro(statusMensagemContrato);
		salvar(movimentoFinanceiro);
		//transferirJD(statusMensagemContrato);
	}
	
	public void respostaTransferenciaTomador(StatusMensagemContrato statusMensagemContrato) {
		MovimentoFinanceiroDO movimentoFinanceiro = prepararMovimentoFinanceiro(statusMensagemContrato);
		salvar(movimentoFinanceiro);
		//transferirJD(statusMensagemContrato);
	}

}