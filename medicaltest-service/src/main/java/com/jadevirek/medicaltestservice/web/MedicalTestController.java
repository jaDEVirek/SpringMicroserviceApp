package com.jadevirek.medicaltestservice.web;


import com.jadevirek.medicaltestservice.domain.entities.MedicalTest;
import com.jadevirek.medicaltestservice.service.MedicalTestService;
import com.jadevirek.medicaltestservice.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/medicaltest")
public class MedicalTestController {
    private final MedicalTestService medicalTestService;
    private final RestTemplate restTemplate;

    @Autowired
    public MedicalTestController(MedicalTestService medicalTestService, RestTemplate restTemplate) {
        this.medicalTestService = medicalTestService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<MedicalTest> getAllMedicalTests() {
          return  this.medicalTestService.getAllMedicalTests();
    }

    @GetMapping("patients")
    public List<MedicalTest> getAllMedicalTestsForPatients() {
        return getAllPatientsMedicalTests();
    }
    public List<MedicalTest> getAllPatientsMedicalTests() {
        // Example of using Ribbon Load Balancer.
        // It can be received from another services.
        final ResponseEntity<List<MedicalTest>> medicalTestResponse = this.restTemplate.exchange(
                "http://PATIENTSERVICE/patient/tests",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<MedicalTest>>() {
                });
        return medicalTestResponse.getBody();
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