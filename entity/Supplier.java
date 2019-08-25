package com.lsr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {
  @Id
  @GeneratedValue
  private int id;

  @Column(name = "SUPPLIERNAME")
  private String supplierName;

  @Column(name = "INTERESTEDADDRESS")
  private String interestedAddress;

  @Column(name = "contactNumber")
  private String contactNumber;

  @Column(name = "location")
  private String location;

  public Supplier() {
    super();
  }

  public Supplier(String supplierName, String interestedAddress, String contactNumber, String location) {
    super();
    this.supplierName = supplierName;
    this.interestedAddress = interestedAddress;
    this.contactNumber = contactNumber;
    this.location = location;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getSupplierName() {
    return supplierName;
  }

  public void setSupplierName(String supplierName) {
    this.supplierName = supplierName;
  }

  public String getInterestedAddress() {
    return interestedAddress;
  }

  public void setInterestedAddress(String interestedAddress) {
    this.interestedAddress = interestedAddress;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }



}
