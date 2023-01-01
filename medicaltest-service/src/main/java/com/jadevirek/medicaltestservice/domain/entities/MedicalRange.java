package com.jadevirek.medicaltestservice.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity public class MedicalRange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer lowerNorm;
    private Integer upperNorm;
    private String testUnits;
    @OneToOne(mappedBy = "range")
    private MedicalTest medicalTest;


    public MedicalRange(long id, Integer lowerNorm, Integer upperNorm, String testUnits, MedicalTest medicalTest) {
        this.id = id;
        this.lowerNorm = lowerNorm;
        this.upperNorm = upperNorm;
        this.testUnits = testUnits;
        this.medicalTest = medicalTest;
    }

    protected MedicalRange() {

    }

    public long getId() {
        return id;
    }

    public Integer getLowerNorm() {
        return lowerNorm;
    }

    public Integer getUpperNorm() {
        return upperNorm;
    }

    public String getTestUnits() {
        return testUnits;
    }

    public MedicalTest getMedicalTest() {
        return medicalTest;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MedicalRange)) {
            return false;
        }
        MedicalRange that = (MedicalRange) o;
        return id == that.id && Objects.equals(lowerNorm, that.lowerNorm) && Objects.equals(upperNorm,
                that.upperNorm) && Objects.equals(testUnits, that.testUnits) && Objects.equals(medicalTest,
                that.medicalTest);
    }

    @Override public int hashCode() {
        return Objects.hash(id, lowerNorm, upperNorm, testUnits, medicalTest);
    }
}
