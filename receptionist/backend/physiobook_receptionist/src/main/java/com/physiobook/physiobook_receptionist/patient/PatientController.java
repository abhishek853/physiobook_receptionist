package com.physiobook.physiobook_receptionist.patient;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@Validated    // @NotBlank and other Bean Validation annotations only work if Spring is told to validate the object and it enables validation support
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping("/createPatient")
    public ResponseEntity<String> createPatient(@Valid @RequestBody Patient patient) {
        patientService.createPatient(patient);
        return new ResponseEntity<>("Patient Created", HttpStatus.CREATED);        
    }
}
