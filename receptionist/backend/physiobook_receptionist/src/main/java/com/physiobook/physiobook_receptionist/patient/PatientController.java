package com.physiobook.physiobook_receptionist.patient;

import java.util.List;
import java.util.Map;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")
@Tag(name = "Receptionist Api`s", description = "Api for Receptionist operation")
@RestController
@Validated    // @NotBlank and other Bean Validation annotations only work if Spring is told to validate the object and it enables validation support
@RequestMapping("/api")
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping("/createPatient")
    @Operation(summary = "create patient api", description = "create patient")
    public ResponseEntity<String> createPatient(@Valid @RequestBody Patient patient) {
        
        try {
            patientService.createPatient(patient);
            return ResponseEntity.status(HttpStatus.OK).body("Patient Created Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create patient");
        }
        
    }

    @GetMapping("/allPatients")
    @Operation(summary = "get all patient", description = "get all patient for the reception")
    public ResponseEntity<List<Patient>> getAllPatients() {

        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @PatchMapping("/updatePatient/{id}")
    @Operation(summary = "update patient", description = "update patient for the reception")
    public ResponseEntity<String> updatePatient(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        
        try {
            patientService.updatePatient(id, updates);
            return ResponseEntity.status(HttpStatus.OK).body("Patient Updated Successfully");

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found with id : "+id);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update patient");
        }
    }

    @DeleteMapping("/deletePatient/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        boolean deleted = patientService.deletePatient(id);
        if (deleted) {
            return new ResponseEntity<>("Patient Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed to delete, patient not found", HttpStatus.NOT_FOUND);
    }
}
