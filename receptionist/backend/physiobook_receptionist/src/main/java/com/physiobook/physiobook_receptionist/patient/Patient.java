package com.physiobook.physiobook_receptionist.patient;

import com.physiobook.physiobook_receptionist.enums.Gender;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
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

    @Column(nullable = false)
    private String status = "waiting";

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;


    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }
}
