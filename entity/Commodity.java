package com.lsr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "commodity")
public class Commodity {
  @Id
  @GeneratedValue
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "quality ")
  private Integer quality;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "location")
  private String location;

  public Commodity() {
    super();
  }

  public Commodity(String name, Integer quality, Integer quantity, String location) {
    super();
    this.name = name;
    this.quality = quality;
    this.quantity = quantity;
    this.location = location;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getQuality() {
    return quality;
  }

  public void setQuality(Integer quality) {
    this.quality = quality;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }



}
