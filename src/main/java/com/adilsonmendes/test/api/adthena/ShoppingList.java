package com.adilsonmendes.test.api.adthena;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.adilsonmendes.test.api.adthena.repository.ProductRepository;

@Component
public class ShoppingList {
  
  @Autowired
  private ProductRepository productRepo;
   
  public void Process(String[] list) {
    
  }
  
  public boolean ValidateList(String[] list) {
    if(!validateShoppingCommand(list)) {
      System.out.println("\n * Validation Error -> Shopping list format unknown");
      return false;
    }
    
    String itemList[] = Arrays.copyOfRange(list, 1, list.length);
    if(!validItemList(itemList))
    {
      System.out.println("\n * Validation Error -> Unknow item found in the shopping list");
      return false;
    }
    
    return true; 
  }
  
  private boolean validItemList(String[] list) {
    for (String product : list) 
      if(!productRepo.isProductExists(product))
         return false;
    return true;
  }
  
  private boolean validateShoppingCommand(String[] list) {
    return list[0].equalsIgnoreCase("PriceBasket");
  }

}
