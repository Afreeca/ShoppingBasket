package com.adilsonmendes.test.api.adthena.model;

public class Product {

  long id;
  String name;
  double price;
  String description;
  SpecialOffer especialOffer;

  public Product(long id, String name, double price, String description) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public SpecialOffer getSpecialOffer() {
    return especialOffer;
  }

  public void setSpecialOffer(SpecialOffer specialOffer) {
    this.especialOffer = specialOffer;
  }

  protected boolean isSpecialOfferExists() {
    return this.especialOffer == null;
  }	

  protected boolean isSpecialOfferConditionExists(String promoName) {
    return this.especialOffer.condition == null;
  } 	
}
