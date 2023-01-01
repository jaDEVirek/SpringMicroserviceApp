package com.jadevirek.medicaltestservice.service;


import com.jadevirek.medicaltestservice.domain.entities.MedicalTestPackage;
import com.jadevirek.medicaltestservice.domain.enums.MedicalField;
import com.jadevirek.medicaltestservice.repository.MedicalTestPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalTestPackageService {
  private final MedicalTestPackageRepository medicalTestPackageRepository;

  @Autowired
  public MedicalTestPackageService(
      MedicalTestPackageRepository medicalTestPackageRepository) {
    this.medicalTestPackageRepository = medicalTestPackageRepository;
  }

  public MedicalTestPackage findPackageForMedicalField(MedicalField medicalField) {
    return this.medicalTestPackageRepository.findByMedicalField(medicalField);
  }

  public List<MedicalTestPackage> getAll() {
    return this.medicalTestPackageRepository.findAll();
  }

}
