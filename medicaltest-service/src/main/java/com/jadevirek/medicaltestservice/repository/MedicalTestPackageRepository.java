package com.jadevirek.medicaltestservice.repository;


import com.jadevirek.medicaltestservice.domain.entities.MedicalTestPackage;
import com.jadevirek.medicaltestservice.domain.enums.MedicalField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalTestPackageRepository extends JpaRepository<MedicalTestPackage, Long> {
    MedicalTestPackage findByMedicalField(MedicalField medicalField);
}
