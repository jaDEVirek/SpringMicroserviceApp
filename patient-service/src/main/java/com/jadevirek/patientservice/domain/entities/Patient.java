package com.jadevirek.patientservice.domain.entities;


import javax.persistence.*;

@Entity
@Table(name="Patient")
public class Patient {
  @Id
  @Column(name = "patient_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name="firstName")
  private String firstName;
  @Column(name="lastName")
  private String lastName;
  @Column(name="emailAddress")
  private String emailAddress;
  @Column(name="address")
  private String address;
  @Column(name="country")
  private String country;
  @Column(name="state")
  private String state;
  @Column(name="phoneNumber")
  private String phoneNumber;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
