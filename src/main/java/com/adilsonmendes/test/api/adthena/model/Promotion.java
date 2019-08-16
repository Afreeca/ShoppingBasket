package com.adilsonmendes.test.api.adthena.model;

import java.sql.Date;

public class Promotion {
    String description;
	String productName;
	int discount;
	Date start;
	Date end;
	Condition condition;
	
  public Promotion() {}

  public Promotion(String description, String productName, int discount, Date start, Date end, Condition condition) {
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

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }

  public Condition getCondition() {
    return condition;
  }

  public void setCondition(Condition condition) {
    this.condition = condition;
  }
  
}
