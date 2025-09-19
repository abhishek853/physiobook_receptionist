package com.physiobook.physiobook_receptionist.patient.ServiceImplementation;

import org.springframework.stereotype.Service;

import com.physiobook.physiobook_receptionist.patient.Patient;
import com.physiobook.physiobook_receptionist.patient.PatientRepository;
import com.physiobook.physiobook_receptionist.patient.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

    PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    
    @Override
    public void createPatient(Patient patient) {
        patientRepository.save(patient);
    }
    
}
