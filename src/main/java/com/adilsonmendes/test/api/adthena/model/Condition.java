package com.adilsonmendes.test.api.adthena.model;

public class Condition {
  int amount;
  int discountOf;
  String onProduct;
  
  public Condition(int amount, int discountOf, String onProduct) 
  {
    this.amount = amount; 
    this.discountOf = discountOf;
    this.onProduct = onProduct;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getDiscountOf() {
    return discountOf;
  }

  public void setDiscountOf(int discountOf) {
    this.discountOf = discountOf;
  }

  public String getOnProduct() {
    return onProduct;
  }

  public void setOnProduct(String onProduct) {
    this.onProduct = onProduct;
  }
}
