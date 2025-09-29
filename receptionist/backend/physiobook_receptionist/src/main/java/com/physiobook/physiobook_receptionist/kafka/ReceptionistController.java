package com.physiobook.physiobook_receptionist.kafka;
import com.physiobook.physiobook_receptionist.kafka.ReceptionistMessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {

    private final ReceptionistMessageService messageService;

    public ReceptionistController(ReceptionistMessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/doctorMessages")
    public List<String> getDoctorMessages() {
        return messageService.getDoctorMessages();
    }

    @GetMapping("/appointmentMessages")
    public List<String> getAppointmentMessages() {
        return messageService.getAppointmentMessages();
    }
}
