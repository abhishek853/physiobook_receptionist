package com.physiobook.physiobook_receptionist.kafka.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceptionistMessageService {

    private final List<String> doctorMessages = new ArrayList<>();
    private final List<String> appointmentMessages = new ArrayList<>();

    public void saveDoctorMessage(String message) {
        doctorMessages.add(message);
    }

    public void saveAppointmentMessage(String message) {
        appointmentMessages.add(message);
    }

    public List<String> getDoctorMessages() {
        return doctorMessages;
    }

    public List<String> getAppointmentMessages() {
        return appointmentMessages;
    }
}
