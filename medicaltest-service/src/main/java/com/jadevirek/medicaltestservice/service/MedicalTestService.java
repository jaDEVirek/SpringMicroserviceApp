package com.jadevirek.medicaltestservice.service;

import com.jadevirek.medicaltestservice.domain.entities.MedicalTest;
import com.jadevirek.medicaltestservice.repository.MedicalTestRepository;
import com.jadevirek.medicaltestservice.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalTestService {
    private final MedicalTestRepository medicalTestRepository;

    @Autowired
    public MedicalTestService(
            MedicalTestRepository medicalTestRepository) {
        this.medicalTestRepository = medicalTestRepository;
    }

    public List<MedicalTest> getAllMedicalTests() {
        return medicalTestRepository.findAll();
    }

    public MedicalTest createMedicalTest(MedicalTest medicalTest) {
        return medicalTestRepository.save(medicalTest);
    }

    public Optional<MedicalTest> getMedicalTestById(Long id) {
        return Optional.ofNullable(medicalTestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MedicalTest", "id", id)));
    }

    public MedicalTest updateMedicalTest(Long id, MedicalTest medicalTest) {
        MedicalTest existingMedicalTest = medicalTestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MedicalTest", "id", id));
        existingMedicalTest.setName(medicalTest.getName());
        existingMedicalTest.setDescription(medicalTest.getDescription());
        existingMedicalTest.setRange(medicalTest.getRange());
        existingMedicalTest.setAboveNormSymptoms(medicalTest.getAboveNormSymptoms());
        existingMedicalTest.setAboveNormReasons(medicalTest.getAboveNormReasons());
        existingMedicalTest.setBelowNormReasons(medicalTest.getBelowNormReasons());
        existingMedicalTest.setBelowNormSymptoms(medicalTest.getBelowNormSymptoms());
        return medicalTestRepository.save(existingMedicalTest);
    }

    public void deleteMedicalTest(Long id) {
        MedicalTest medicalTest = medicalTestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MedicalTest", "id", id));
        medicalTestRepository.delete(medicalTest);
    }
}

