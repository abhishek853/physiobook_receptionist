package com.physiobook.physiobook_receptionist.patient;

import java.util.List;
import java.util.Map;

public interface PatientService {
    void createPatient(Patient patient);
    List<Patient> getAllPatients();
    void updatePatient(Long id, Map<String, Object> updates);
    boolean deletePatient(Long id);
}
