package com.jadevirek.medicaltestservice.domain.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity public class MedicalTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Version
    private int version;
    @Column
    private String name;
    @Column(length = 2000)
    private String description;
    @OneToOne
    @JoinColumn(name = "range_Id", referencedColumnName = "id")
    private MedicalRange range;
    @Column
    private String aboveNormSymptoms;
    @Column
    private String aboveNormReasons;
    @Column
    private String belowNormReasons;
    @Column
    private String belowNormSymptoms;

    protected MedicalTest() {
    }

    public MedicalTest(long id, int version, String name, String description, MedicalRange range,
            String aboveNormSymptoms, String aboveNormReasons, String belowNormReasons, String belowNormSymptoms) {
        this.id = id;
        this.version = version;
        this.name = name;
        this.description = description;
        this.range = range;
        this.aboveNormSymptoms = aboveNormSymptoms;
        this.aboveNormReasons = aboveNormReasons;
        this.belowNormReasons = belowNormReasons;
        this.belowNormSymptoms = belowNormSymptoms;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MedicalTest)) {
            return false;
        }
        MedicalTest that = (MedicalTest) o;
        return id == that.id && version == that.version && Objects.equals(name, that.name) && Objects.equals(
                description, that.description) && Objects.equals(range, that.range) && Objects.equals(aboveNormSymptoms,
                that.aboveNormSymptoms) && Objects.equals(aboveNormReasons, that.aboveNormReasons) && Objects.equals(
                belowNormReasons, that.belowNormReasons) && Objects.equals(belowNormSymptoms, that.belowNormSymptoms);
    }

    @Override public int hashCode() {
        return Objects.hash(id, version, name, description, range, aboveNormSymptoms, aboveNormReasons,
                belowNormReasons, belowNormSymptoms);
    }

    public long getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public MedicalRange getRange() {
        return range;
    }

    public String getAboveNormSymptoms() {
        return aboveNormSymptoms;
    }

    public String getAboveNormReasons() {
        return aboveNormReasons;
    }

    public String getBelowNormReasons() {
        return belowNormReasons;
    }

    public String getBelowNormSymptoms() {
        return belowNormSymptoms;
    }
}
