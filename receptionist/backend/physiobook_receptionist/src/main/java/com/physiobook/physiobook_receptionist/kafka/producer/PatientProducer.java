package com.physiobook.physiobook_receptionist.kafka.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.physiobook.physiobook_receptionist.patient.Patient;

@Service
public class PatientProducer {
    
    private final KafkaTemplate<String, Patient> kafkaTemplate;

    @Value("${app.kafka.topic.patient}")
    private String patientTopic;

    public PatientProducer(KafkaTemplate<String, Patient> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPatientData(Patient patient) {
        System.out.println("In send patient data method");
        kafkaTemplate.send(patientTopic, patient);
        System.out.println("Patient data -> Sent to topic(" + patientTopic + "): " + patient);
    }
}
