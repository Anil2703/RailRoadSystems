package com.rocky.publisher;

import com.rocky.model.Waybill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class WaybillEventPublisher {

    private static final Logger logger = LoggerFactory.getLogger(WaybillEventPublisher.class);
    private static final String TOPIC = "waybill-events";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public WaybillEventPublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishWaybill(Waybill waybill) {
        logger.info("Publishing waybill to Kafka topic '{}': {}", TOPIC, waybill);
        kafkaTemplate.send(TOPIC, waybill);
    }
}
