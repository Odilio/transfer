package br.com.b3.pip.gerenciarrecurso.adapters.messagebrokers.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import br.com.b3.pip.gerenciarrecurso.exceptions.KafkaCommunicationException;

@EnableRetry
@Service
public class ReceberTransferenciaDoadorProducer {
    
    private static final Logger LOG = LoggerFactory.getLogger(ReceberTransferenciaDoadorProducer.class);

    @Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${kafka.topic.pi-pip-receber-transferencia-doador}")
	private String topicResp;
    
    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 10, multiplier = 5, random = true, maxDelay = 5000))
    public void sendWithRetry(String mensagem) throws KafkaCommunicationException {
        try {
            LOG.info("Trying to send message to topic {}", topicResp);

            kafkaTemplate.send(topicResp, mensagem);

            LOG.info("Message was published on kafka topic {}", topicResp);
        } catch (KafkaException e) {
            String error = "Problema ao inserir mensagem no tópico. (e.g. partição não existe ou com problemas)";
            LOG.error(error, e);
            throw new KafkaCommunicationException(error, e);
        }
    }

    @Recover
    public void retryFallback(Throwable e) throws Throwable {
        LOG.warn("Exceeded the retries limit. Exception: ", e);
        throw e;
    }
}
