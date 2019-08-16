package com.adilsonmendes.test.api.adthena.repository;

import java.util.Hashtable;
import org.springframework.stereotype.Component;
import com.adilsonmendes.test.api.adthena.model.Promotion;

@Component
public class PromotionRepository {
  private Hashtable<String, Promotion> promotionList;
  
  public PromotionRepository() {
    promotionList = new Hashtable<String, Promotion>();
  }
  
  public void addPromotion(Promotion promotion) {
      promotionList.put(promotion.getDescription(), promotion);
  }
  
  protected void removePromotion(String description) {
      promotionList.remove(description);
  }
  
  protected void removePromotion(Promotion promotion) {
      promotionList.remove(promotion.getDescription(), promotion);
  }
  
  protected void getPromotions(String description) {
      promotionList.get(description);
  }

  protected void isPromotionExists(String description) {
      promotionList.containsKey(description);
  }
  
  protected void isPromotionExists(Promotion promotion) {
      promotionList.containsValue(promotion);
  }
}
