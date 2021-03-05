package br.com.b3.pip.gerenciarrecurso.adapters.messagebrokers.kafka.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.b3.pip.gerenciarrecurso.core.GerenciarRecursoService;
import br.com.b3.pip.gerenciarrecurso.exceptions.KafkaCommunicationException;
import br.com.b3.pip.gerenciarrecurso.model.StatusMensagemContrato;

@Service
public class EnviarTransferenciaTomadorConsumer {
	
	@Autowired
	private GerenciarRecursoService gerenciarRecursoService;
	
	public static final Logger logger = LoggerFactory.getLogger(EnviarTransferenciaTomadorConsumer.class);
	
	@KafkaListener(topics = "${kafka.topic.pi-pip-enviar-transferencia-tomador}", groupId = "${kafka.group-id}")
    public void enviarTransferenciaTomadorConsumer(String mensagem) throws IOException, KafkaCommunicationException {
		logger.info("@KafkaListener - pi-pip-enviar-transferencia-tomador - [{}]", mensagem);
		StatusMensagemContrato statusMensagemContrato = StatusMensagemContrato.convertToObject(mensagem);
		gerenciarRecursoService.respostaTransferenciaTomador(statusMensagemContrato);
	}

}
