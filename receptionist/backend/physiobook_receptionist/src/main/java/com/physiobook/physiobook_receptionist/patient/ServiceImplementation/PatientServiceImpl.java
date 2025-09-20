package com.physiobook.physiobook_receptionist.patient.ServiceImplementation;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.physiobook.physiobook_receptionist.enums.Gender;
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

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public void updatePatient(Long id, Map<String, Object> updates) {        

        Patient patient = patientRepository.findById(id)
                                            .orElseThrow(() -> new RuntimeException("Patient Not Found with Id: " + id));        

        updates.forEach((Key, value) -> {
            switch (Key) {
                case "name": 
                    patient.setName( (String) value);
                    break;

                case "age": 
                    patient.setAge( (int) value);
                    break;

                case "gender": 
                    patient.setGender( (Gender) value);
                    break;

                case "weight": 
                    patient.setWeight( (int) value);
                    break;

                case "phone": 
                    patient.setPhone( (String) value);
                    break;
            
                default: throw new IllegalArgumentException("Invalid Field : "+Key);
            }
        });

        patientRepository.save(patient);
    }
    
    @Override
    public boolean deletePatient(Long id){
        try {
            patientRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
