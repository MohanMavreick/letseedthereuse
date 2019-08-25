package com.lsr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buyer")
public class Buyer {
  @Id
  @GeneratedValue
  private int id;

  @Column(name = "buyerName")
  private String buyerName;

  @Column(name = "buyerAddress ")
  private String buyerAddress;

  @Column(name = "contactNumber")
  private String contactNumber;

  @Column(name = "location")
  private String location;

  public Buyer() {
    super();
  }

  public Buyer(String buyerName, String buyerAddress, String contactNumber, String location) {
    super();
    this.buyerName = buyerName;
    this.buyerAddress = buyerAddress;
    this.contactNumber = contactNumber;
    this.location = location;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBuyerName() {
    return buyerName;
  }

  public void setBuyerName(String buyerName) {
    this.buyerName = buyerName;
  }

  public String getBuyerAddress() {
    return buyerAddress;
  }

  public void setBuyerAddress(String buyerAddress) {
    this.buyerAddress = buyerAddress;
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
