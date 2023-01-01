package com.jadevirek.patientservice.web;

import com.jadevirek.patientservice.domain.entities.Patient;
import com.jadevirek.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> list = patientService.getAllPatients();
        return new ResponseEntity<List<Patient>>(list, HttpStatus.OK);
    }

}
