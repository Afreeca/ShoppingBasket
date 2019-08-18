package com.adilsonmendes.test.adthena;

import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.adilsonmendes.test.api.adthena.model.Condition;
import com.adilsonmendes.test.api.adthena.model.Product;
import com.adilsonmendes.test.api.adthena.model.SpecialOffer;
import com.adilsonmendes.test.api.adthena.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingListTest {
  
  @Mock
  ProductRepository productRepo;
  
  private Product productA;
  private Product productB;
  private SpecialOffer specialOffer;
  private Condition condition;
  
  @Before
  public void setUp() {
    productA = new Product(1, "Bread", 0.50, "loaf");
    productB = new Product(1, "Milk", 1.00, "l");
    condition = new Condition(3, 30, "Bread");
    specialOffer = new SpecialOffer("applePromo", 10, LocalDate.now(), LocalDate.now().plusWeeks(2), condition);
  }
  
  
  @After
  public void cleanUp() {
      productA = null;
      productB = null;
      condition = null;
      specialOffer = null;
  }
  
}
