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
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient patient) {
        Patient existingPatient = patientRepository.findById(id).orElse(null);
        if (existingPatient != null) {
            // ustaw pola obiektu existingPatient na nowe wartości z obiektu patient
            existingPatient.setFirstName(patient.getFirstName());
            existingPatient.setAddress(patient.getAddress());
            existingPatient.setPhoneNumber(patient.getPhoneNumber());
            // zapisz zmodyfikowanego pacjenta
            return patientRepository.save(existingPatient);
        } else {
            return null;
        }
    }
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

}