package com.school.msreservation.infrastructure.adapter.adapterOut;

import com.school.msreservation.domain.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
@Slf4j
public class ReservationAdapterOutImpl implements ReservationAdapterOut {
    private static final Logger logger = LoggerFactory.getLogger(ReservationAdapterOut.class);
    @Autowired
    private KafkaTemplate<String, Reservation> kafkaTemplate;

    @Value("${topic.name}")
    private String topic;

    public ReservationAdapterOutImpl(KafkaTemplate kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;

    }

    @Override
    public void postReservation(Reservation reservation) {
        kafkaTemplate.send(this.topic, reservation).whenComplete((result, ex)-> {
                    if (ex != null) {
                        logger.info("Message failure: " + ex.getMessage());
                    } else {
                        RecordMetadata metadata = result.getRecordMetadata();
                        logger.info("✅ Mensagem enviada com sucesso para o tópico: " +
                                metadata.topic() + " | partição: " + metadata.partition() +
                                " | offset: " + metadata.offset() + "Mesensagem postada {}", reservation );
                    }
        });
    }
}
