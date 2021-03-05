package br.com.b3.pip.gerenciarrecurso.core.impl;

import org.springframework.stereotype.Service;

import br.com.b3.pip.gerenciarrecurso.adapters.messagebrokers.kafka.producer.ReceberTransferenciaDoadorProducer;
import br.com.b3.pip.gerenciarrecurso.core.TransaferenciasService;
import br.com.b3.pip.gerenciarrecurso.model.StatusMensagemContrato;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TransaferenciasServiceImpl implements TransaferenciasService {

	@Autowired
	private ReceberTransferenciaDoadorProducer receberTransferenciaDoadorProducer;
	
	public static final Logger logger = LoggerFactory.getLogger(TransaferenciasServiceImpl.class);
	
	public void receberRecursos(StatusMensagemContrato statusMensagemContrato) {
		String mensagem = StatusMensagemContrato.convertToString(statusMensagemContrato);
		try {
			receberTransferenciaDoadorProducer.sendWithRetry(mensagem);
		} catch (Exception e) {
			logger.error("TransaferenciasServiceImpl - " + e.getMessage());
		}
	}
}