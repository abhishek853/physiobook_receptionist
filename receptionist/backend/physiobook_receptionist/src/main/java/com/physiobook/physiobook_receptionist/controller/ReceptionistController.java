package com.physiobook.physiobook_receptionist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Receptionist Api`s", description = "Api for Receptionist operation")
public class ReceptionistController {

    @GetMapping("/welcome")
    @Operation(summary = "welcome api", description = "greet a welcome msg")
    public String welcome() {
        return "Welcome, Receptionist";
    }
}