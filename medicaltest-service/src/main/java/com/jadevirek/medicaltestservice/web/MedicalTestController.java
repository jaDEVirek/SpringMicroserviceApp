package com.jadevirek.medicaltestservice.web;


import com.jadevirek.medicaltestservice.domain.entities.MedicalTest;
import com.jadevirek.medicaltestservice.service.MedicalTestService;
import com.jadevirek.medicaltestservice.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/medicaltest")
public class MedicalTestController {
    private final MedicalTestService medicalTestService;

    @Autowired
    public MedicalTestController(MedicalTestService medicalTestService) {
        this.medicalTestService = medicalTestService;
    }

    @GetMapping
    public List<MedicalTest> getAllMedicalTests() {
        return medicalTestService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalTest> getMedicalTestById(@PathVariable(value = "id") Long medicalTestId) {
        MedicalTest medicalTest = medicalTestService.findById(medicalTestId)
                .orElseThrow(() -> new ResourceNotFoundException("MedicalTest", "id", medicalTestId));
        return ResponseEntity.ok().body(medicalTest);
    }

    @PostMapping
    public MedicalTest createMedicalTest(@Valid @RequestBody MedicalTest medicalTest) {
        return medicalTestService.save(medicalTest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalTest> updateMedicalTest(@PathVariable(value = "id") Long medicalTestId,
            @Valid @RequestBody MedicalTest medicalTestDetails) {
        MedicalTest medicalTest = medicalTestService.getMedicalTestById(medicalTestId)
                .orElseThrow(() -> new ResourceNotFoundException("MedicalTest", "id", medicalTestId));
        medicalTest.setName(medicalTestDetails.getName());
        medicalTest.setDescription(medicalTestDetails.getDescription());
        medicalTest.setRange(medicalTestDetails.getRange());
        medicalTest.setAboveNormSymptoms(medicalTestDetails.getAboveNormSymptoms());
        medicalTest.setAboveNormReasons(medicalTestDetails.getAboveNormReasons());
        medicalTest.setBelowNormReasons(medicalTestDetails.getBelowNormReasons());
        medicalTest.setBelowNormSymptoms(medicalTestDetails.getBelowNormSymptoms());

        MedicalTest updatedMedicalTest = medicalTestService.updateMedicalTest(medicalTest);
        return ResponseEntity.ok(updatedMedicalTest);
    }

    @PutMapping("/{id}")
    public MedicalTest updateMedicalTest(@PathVariable Long id, @RequestBody MedicalTest medicalTest) {
        MedicalTest existingMedicalTest = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MedicalTest", "id", id));
        existingMedicalTest.setName(medicalTest.getName());
        existingMedicalTest.setDescription(medicalTest.getDescription());
        existingMedicalTest.setRange(medicalTest.getRange());
        existingMedicalTest.setAboveNormSymptoms(medicalTest.getAboveNormSymptoms());
        existingMedicalTest.setAboveNormReasons(medicalTest.getAboveNormReasons());
        existingMedicalTest.setBelowNormReasons(medicalTest.getBelowNormReasons());
        existingMedicalTest.setBelowNormSymptoms(medicalTest.getBelowNormSymptoms());
        return repository.save(existingMedicalTest);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedicalTest(@PathVariable Long id) {
        MedicalTest medicalTest = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MedicalTest", "id", id));
        repository.delete(medicalTest);
        return ResponseEntity.ok().build();
    }
}