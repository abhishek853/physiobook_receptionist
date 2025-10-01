package com.physiobook.physiobook_receptionist.kafka.controller;
import com.physiobook.physiobook_receptionist.kafka.producer.ReceptionistProducer;
import com.physiobook.physiobook_receptionist.kafka.service.ReceptionistMessageService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {

    private final ReceptionistMessageService messageService;
    private final ReceptionistProducer receptionistProducer;

    public ReceptionistController(ReceptionistMessageService messageService, ReceptionistProducer receptionistProducer) {
        this.messageService = messageService;
        this.receptionistProducer = receptionistProducer;
    }

    @GetMapping("/doctorMessages")
    public List<String> getDoctorMessages() {
        return messageService.getDoctorMessages();
    }

    @GetMapping("/appointmentMessages")
    public List<String> getAppointmentMessages() {
        return messageService.getAppointmentMessages();
    }

    @PostMapping("/sendEvent")
    public String sendReceptionistEvent(@RequestParam String message){
        receptionistProducer.sendReceptionistEvent(message);
        return "Receptionist event sent: " + message;
    }    
}
