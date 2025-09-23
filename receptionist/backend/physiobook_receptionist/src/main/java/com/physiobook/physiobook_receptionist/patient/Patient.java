package com.physiobook.physiobook_receptionist.patient;

import com.physiobook.physiobook_receptionist.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int age;
    private int weight;    

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    @NotBlank(message = "Phone Number cannot be blank")
    private String phone;
    
}
