package com.jadevirek.medicaltestservice.domain.entities;


import com.jadevirek.medicaltestservice.domain.enums.MedicalField;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MedicalTestPackage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Enumerated
  private MedicalField medicalField;
  @OneToMany
  @JoinColumn(name = "test_id")
  private Set<MedicalTest> medicalTests = new HashSet<>();

  public MedicalTestPackage(long id, MedicalField medicalField,
      Set<MedicalTest> medicalTests) {
    this.id = id;
    this.medicalField = medicalField;
    this.medicalTests = medicalTests;
  }

  protected MedicalTestPackage() {

  }
}
