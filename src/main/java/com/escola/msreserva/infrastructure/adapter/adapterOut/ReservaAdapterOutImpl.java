package com.escola.msreserva.infrastructure.adapter.adapterOut;

import com.escola.msreserva.application.portOut.ReservaPortOut;
import com.escola.msreserva.domain.Reserva;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
@Slf4j
public class ReservaAdapterOutImpl implements ReservaAdapterOut{
    private static final Logger logger = LoggerFactory.getLogger(ReservaAdapterOut.class);
    @Autowired
    private KafkaTemplate<String, Reserva> kafkaTemplate;

    @Value("${topic.name}")
    private String topic;

    public ReservaAdapterOutImpl( KafkaTemplate kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;

    }

    @Override
    public void postarReserva(Reserva reserva) {
        kafkaTemplate.send(this.topic, reserva).whenComplete((result, ex)-> {
                    if (ex != null) {
                        logger.info("Message failure: " + ex.getMessage());
                    } else {
                        RecordMetadata metadata = result.getRecordMetadata();
                        logger.info("✅ Mensagem enviada com sucesso para o tópico: " +
                                metadata.topic() + " | partição: " + metadata.partition() +
                                " | offset: " + metadata.offset() + "Mesensagem postada {}", reserva );
                    }
        });
    }
}
