package com.physiobook.physiobook_receptionist.kafka;
import com.physiobook.physiobook_receptionist.kafka.ReceptionistMessageService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ReceptionistConsumer {

    private final ReceptionistMessageService messageService;

    public ReceptionistConsumer(ReceptionistMessageService messageService) {
        this.messageService = messageService;
    }

    @KafkaListener(topics = "${app.kafka.topic.doctor}", groupId = "receptionist-group")
    public void listenDoctorEvents(String message) {
        System.out.println("Receptionist Service -> Received doctor event: " + message);
        messageService.saveDoctorMessage(message);
    }

    @KafkaListener(topics = "${app.kafka.topic.appointment}", groupId = "receptionist-group")
    public void listenAppointmentEvents(String message) {
        System.out.println("Receptionist Service -> Received appointment event: " + message);
        messageService.saveAppointmentMessage(message);
    }
}
