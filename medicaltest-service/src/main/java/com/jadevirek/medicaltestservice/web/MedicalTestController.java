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
        return medicalTestService.getAllMedicalTests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalTest> getMedicalTestById(@PathVariable(value = "id") Long medicalTestId) {
        MedicalTest medicalTest = medicalTestService.getMedicalTestById(medicalTestId)
                .orElseThrow(() -> new ResourceNotFoundException("MedicalTest", "id", medicalTestId));
        return ResponseEntity.ok().body(medicalTest);
    }

    @PostMapping
    public MedicalTest createMedicalTest(@Valid @RequestBody MedicalTest medicalTest) {
        return medicalTestService.createMedicalTest(medicalTest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalTest> updateMedicalTest(@PathVariable(value = "id") Long medicalTestId,
            @Valid @RequestBody MedicalTest medicalTestDetails) {
        MedicalTest updatedMedicalTest = medicalTestService.updateMedicalTest(medicalTestId,medicalTestDetails);
        return ResponseEntity.ok(updatedMedicalTest);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedicalTest(@PathVariable Long id) {
        medicalTestService.deleteMedicalTest(id);
        return ResponseEntity.ok().build();
    }
}