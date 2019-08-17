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
}
