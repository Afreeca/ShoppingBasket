package com.adilsonmendes.test.api.adthena.repository;

import java.util.Hashtable;
import org.springframework.stereotype.Component;
import com.adilsonmendes.test.api.adthena.model.SpecialOffer;

@Component
public class SpecialOfferRepository {
  
private Hashtable<String, SpecialOffer> specialOfferList;
  
  public SpecialOfferRepository() {
    specialOfferList = new Hashtable<String, SpecialOffer>();
  }
  
  public void addSpecialOffer(SpecialOffer specialOffer) {
      specialOfferList.put(specialOffer.getDescription(), specialOffer);
  }
  
  protected void removeSpecialOffer(String description) {
      specialOfferList.remove(description);
  }
  
  protected void removeSpecialOffer(SpecialOffer specialOffer) {
      specialOfferList.remove(specialOffer.getDescription(), specialOffer);
  }
  
  protected void getSpecialOffers(String description) {
      specialOfferList.get(description);
  }

  protected void isSpecialOfferExists(String description) {
      specialOfferList.containsKey(description);
  }
  
  protected void isSpecialOfferExists(SpecialOffer specialOffer) {
      specialOfferList.containsValue(specialOffer);
  }
}