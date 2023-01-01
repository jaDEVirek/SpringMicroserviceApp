package com.jadevirek.medicaltestservice.repository;

import com.jadevirek.medicaltestservice.domain.entities.MedicalTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicalTestRepository extends JpaRepository<MedicalTest,Long> {

}
