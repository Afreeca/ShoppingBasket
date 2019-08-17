package com.adilsonmendes.test.api.adthena.model;

import java.time.LocalDate;

public class SpecialOffer {
    String description;
	String productName;
	int discount;
	LocalDate start;
	LocalDate end;
	Condition condition;
	
  public SpecialOffer() {}

  public SpecialOffer(String description, String productName, int discount, LocalDate start, LocalDate end, Condition condition) {
    this.description = description;
    this.productName = productName;
    this.discount = discount;
    this.start = start;
    this.end = end;
    this.condition = condition;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getDiscount() {
    return discount;
  }

  public void setDiscount(int discount) {
    this.discount = discount;
  }

  public LocalDate getStart() {
    return start;
  }

  public void setStart(LocalDate start) {
    this.start = start;
  }

  public LocalDate getEnd() {
    return end;
  }

  public void setEnd(LocalDate localDate) {
    this.end = localDate;
  }

  public Condition getCondition() {
    return condition;
  }

  public void setCondition(Condition condition) {
    this.condition = condition;
  }
  
}
