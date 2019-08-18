package com.adilsonmendes.test.api.adthena.repository;

import java.util.ArrayList;
import java.util.Hashtable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.adilsonmendes.test.api.adthena.model.Product;
import com.adilsonmendes.test.api.adthena.utils.Helper;

@Component
public class ProductRepository {

  @Autowired
  Helper helper;
  
  private Hashtable<String, Product> productList;

  public ProductRepository() {
    productList = new Hashtable<String, Product>();
  }

  public void addProduct(Product product) {
    productList.put(product.getName(), product);
  }

  public Product getProduct(String name) {
    String nameCap = helper.capitalizeFirstLetter(name);
    return productList.get(nameCap);
  }

  public boolean isProductExists(String name) {
    String nameCap = helper.capitalizeFirstLetter(name);
    return productList.containsKey(nameCap);
  }

  protected boolean isProductExists(Product product) {
    return productList.containsValue(product);
  }
  
  public ArrayList<Product> getProductList(String product[]) {
    ArrayList<Product> shoppingList = new ArrayList<>();
    for (String prod : product)
        shoppingList.add(getProduct(prod));
    return shoppingList;
  }

  public void print() {
    System.out.println("\n************* Products Available ****************\n");
    productList.forEach((k,p)->System.out.println(String.format("%s price : %.2f ", k,  p.getPrice())));
  }
   
}
