package com.adilsonmendes.test.api.adthena.repository;

import java.util.Hashtable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.adilsonmendes.test.api.adthena.model.Product;

@Component
public class ProductRepository {
  
	  private Hashtable<String, Product> productList;
	
	  public ProductRepository() {
		  productList = new Hashtable<String, Product>();
	  }
	  
	  public void addProduct(Product product) {
		  productList.put(product.getName(), product);
	  }
	  
	  public void removeProduct(String name) {
		  productList.remove(name);
	  }
	  
	  public void removeProduct(Product product) {
		  productList.remove(product.getName(), product);
	  }
	  
	  public void getProducts(String name) {
		  productList.get(name);
	  }

	  public boolean isProductExists(String name) {
	      String nameCap = CapitalizeFirstLetter(name);
		  return productList.containsKey(nameCap);
	  }
	  
	  protected boolean isProductExists(Product product) {
		  return productList.containsValue(product);
	  }
	  
	  public void print() {
	    System.out.println("\n************* Products Available ****************\n");
        productList.forEach((k,p)->System.out.println(String.format("%s price : %.2f ", k,  p.getPrice())));
    }
	  
	  private String CapitalizeFirstLetter(String str) {
	    return StringUtils.capitalize(str);
	  }
}
