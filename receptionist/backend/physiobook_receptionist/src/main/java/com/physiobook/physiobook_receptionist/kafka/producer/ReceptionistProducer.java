package com.physiobook.physiobook_receptionist.kafka.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReceptionistProducer {
    
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.kafka.topic.receptionist}")
    private String receptionistTopic;

    public ReceptionistProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendReceptionistEvent(String message){
        kafkaTemplate.send(receptionistTopic, message);
        System.out.println("Receptionist event -> Sent to topic("+receptionistTopic+"): "+message);
    }
}
