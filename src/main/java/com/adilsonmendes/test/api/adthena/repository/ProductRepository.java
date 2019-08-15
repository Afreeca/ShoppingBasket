package com.adilsonmendes.test.api.adthena.repository;

import java.util.Hashtable;

import com.adilsonmendes.test.api.adthena.model.Product;

public class ProductRepository {
	
	  private Hashtable<String, Product> productList;
	
	  public ProductRepository() {
		  productList = new Hashtable<String, Product>();
	  }
	  
	  public void addProduct(Product product) {
		  productList.put(product.getName(), product);
	  }
	  
	  protected void removeProduct(String name) {
		  productList.remove(name);
	  }
	  
	  protected void removeProduct(Product product) {
		  productList.remove(product.getName(), product);
	  }
	  
	  protected void getProducts(String name) {
		  productList.get(name);
	  }

	  protected void isProductExists(String name) {
		  productList.containsKey(name);
	  }
	  
	  protected void isProductExists(Product product) {
		  productList.containsValue(product);
	  }
}
