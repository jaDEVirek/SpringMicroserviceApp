package com.jadevirek.patientservice.service;

import com.jadevirek.patientservice.domain.entities.Patient;
import com.jadevirek.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return  patientRepository.findAll();
    }

    public Patient getPatientById(Long patientId) {
            return this.patientRepository.findById(patientId).orElse(new Patient());

            }

}