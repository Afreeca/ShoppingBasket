package com.adilsonmendes.test.adthena.repository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.Hashtable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.adilsonmendes.test.api.adthena.model.Condition;
import com.adilsonmendes.test.api.adthena.model.Product;
import com.adilsonmendes.test.api.adthena.model.SpecialOffer;
import com.adilsonmendes.test.api.adthena.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductRepositoryTest {
  
  @Mock
  ProductRepository productRepo;
  
  private Product productA;
  private Product productB;
  private SpecialOffer specialOffer;
  private Condition condition;
  Hashtable<String, Product> productList;
  
  @Before
  public void setUp() {
    productA = new Product(1, "Bread", 0.50, "loaf");
    condition = new Condition(3, 30, "Bread");
    specialOffer = new SpecialOffer("breadPromo", 10, LocalDate.now(), LocalDate.now().plusWeeks(2), condition);
    productA.setSpecialOffer(specialOffer);
    productList = new Hashtable<String, Product>();
  }
  
  @Test
  public void testAddProduct(){
    productA = new Product(1, "Bread", 0.50, "loaf");
    productList.put(productA.getName(), productA);
    verify(productList, times(1)).put(productA.getName(), productA);
  }
  
  @Test
  public void testGetProduct(){
    productA = new Product(1, "Bread", 0.50, "loaf");
    when(productRepo.getProduct("Bread")).thenReturn(productA);
  }
  
  
  @After
  public void cleanUp() {
      productA = null;
      productB = null;
      condition = null;
      specialOffer = null;
  }
}
