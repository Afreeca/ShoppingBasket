package com.adilsonmendes.test.api.adthena;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.adilsonmendes.test.api.adthena.model.Product;
import com.adilsonmendes.test.api.adthena.repository.ProductRepository;
import com.adilsonmendes.test.api.adthena.utils.Helper;

@Component
public class ShoppingList {
  
  @Autowired
  private ProductRepository productRepo;
  
  @Autowired
  private Helper helper;
   
  public void Process(ArrayList<Product> list) {
    
    double subTotalPrice = calculateSubTotal(list);
    double totalPrice = 0;
    
    System.out.println(String.format("\nSubtotal: £%.2f", subTotalPrice));
    
    for (Product product : list) {
      double newPrice = product.getPrice();
      if(product.getSpecialOffer() != null) {
        System.out.println(generateSpecialOfferText(product));
        newPrice = applySpecialOffer(list, product);
      }
      totalPrice += newPrice;
    }
    
    System.out.println(String.format("Total: £%.2f", totalPrice));
  }
  
  private double calculateSubTotal(ArrayList<Product> list) {
    double subTotal = 0;
    for (Product product : list)
       subTotal +=product.getPrice();
    return subTotal;
  }
  
  private double applySpecialOffer(ArrayList<Product> list, Product product) {
    int discount = product.getSpecialOffer().getDiscount();
    if (discount != 0)
        return helper.calculatePercentage(product.getPrice(), discount);
    
    int quantity =  product.getSpecialOffer().getCondition().getAmount();
    long occurance = calculateProductOccurances(list, product.getSpecialOffer().getCondition().getOnProduct());
    
    discount = product.getSpecialOffer().getCondition().getDiscountOf();
    if(occurance == quantity)
        return helper.calculatePercentage(product.getPrice(), discount);
    return product.getPrice();
  }
  
  private long calculateProductOccurances(ArrayList<Product> list, String product) {
    return list
        .stream()
        .filter(p -> p.getName().equals(helper.capitalizeFirstLetter(product)))
        .count();
  }
  
  private String generateSpecialOfferText(Product product) {
    if (product.getSpecialOffer().getDiscount() != 0)
        return String.format("%s have a %d%% discount off their normal price this week.", product.getName(), product.getSpecialOffer().getDiscount());
    
    String productOf =  product.getSpecialOffer().getCondition().getOnProduct();
    int amount = product.getSpecialOffer().getCondition().getAmount();
    String discount = getDiscountText(product.getSpecialOffer().getCondition().getDiscountOf());
    String plural = amount > 1 ? "s" : "";
    String packaging = product.getDescription().concat(plural);
    String packagingOf = productRepo.getProduct(productOf).getDescription();
    return String.format("Buy %d %s of %s and get a %s of %s for %s.", amount, packagingOf, productOf, packaging, product.getName(), discount);
  }
  
  private String getDiscountText(int discountOf){
    switch (discountOf) {
      case 50 :
        return "half price";
      case 100 :
        return "free";
      default:
        return String.format("%d%% discount", discountOf);
    }
  }

  protected boolean isValidItemList(String[] list) {
    for (String product : list) 
      if(!productRepo.isProductExists(product))
      {
        System.out.println("\n * Validation Error -> Unknow item found in the shopping list");
        return false;
      } 
    return true;
  }
  
  protected boolean isValidateShoppingCommand(String[] list) {
     if(!list[0].equalsIgnoreCase("PriceBasket")){
       System.out.println("\n * Validation Error -> Shopping list format unknown");
       return false;
     }
     return true;
  }
}
