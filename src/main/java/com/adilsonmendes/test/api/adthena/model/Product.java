package com.adilsonmendes.test.api.adthena.model;

import java.util.Hashtable;

public class Product {
	
	long id;
	String name;
	double price;
	String description;
    private Hashtable<String, EspecialOffer> promotionList;
	
	public Product(long id, String name, double price, String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		promotionList = new Hashtable<>();
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
	
	public void addPromotion(EspecialOffer promotion) {
	    this.promotionList.put(promotion.getDescription(), promotion);
	}
	  
	protected void removePromotion(String description) {
	    this.promotionList.remove(description);
	}
	
	protected void isPromotionExists() {
	    this.promotionList.isEmpty();
	}	  
}
