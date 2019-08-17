package com.adilsonmendes.test.api.adthena;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.adilsonmendes.test.api.adthena.model.Condition;
import com.adilsonmendes.test.api.adthena.model.Product;
import com.adilsonmendes.test.api.adthena.model.SpecialOffer;
import com.adilsonmendes.test.api.adthena.repository.ProductRepository;
import com.adilsonmendes.test.api.adthena.utils.Helper;

@SpringBootApplication
public class ShoppingBasquetApplication implements CommandLineRunner {
  
  @Autowired
  private ProductRepository productRepo;
  
  @Autowired
  private ShoppingList shopList;
  
  @Autowired
  Helper helper;
  
  private static Logger LOG = LoggerFactory.getLogger(ShoppingBasquetApplication.class);
  static Scanner input;

  public static void main(String[] args) {
    LOG.info("************* Shopping Application Init ****************");
    input = new Scanner(System.in);
    SpringApplication app = new SpringApplication(ShoppingBasquetApplication.class);
    app.setBannerMode(Banner.Mode.OFF);
    app.run(args);
    LOG.info("************* Shopping Application Terminate ************");
    cleanAndTerminate();
  }

  @Override
  public void run(String... args) {	        
    generateProduct(); // generating all available product for shopping
    productRepo.print(); // displaying available products
    
    String listArray[];
    String itemList[];
    
    // while the shopping command (PriceBasket) or the items are invalid keep running the App;
    do {
      System.out.print("\nEnter your shopping list in the format: PriceBasket item1 item2 item3...\n>");
      String shoppingList = input.nextLine();
      listArray = shoppingList.split(" "); // split by words and convert the input into an array;
      itemList = helper.removeFirstItemArray(listArray) ; // getting just the items from the array
    }
    while( !shopList.isValidateShoppingCommand(listArray) || !shopList.isValidItemList(itemList)); // validated the format of the shopping list
    
    ArrayList<Product> checkoutProductList = productRepo.getProductList(itemList); // get the product objects based on their names
    shopList.Process(checkoutProductList); // process and display the basket
  }
  
  private void generateProduct() {
    
    // creating products
    Product soup = new Product(1, "Soup", 0.65, "tin");
    Product bread = new Product(1, "Bread", 0.80, "loaf");
    Product milk = new Product(1, "Milk", 1.30, "bottle");
    Product apple = new Product(1, "Apples", 1.00, "bag");
    
    // adding products to the list
    productRepo.addProduct(soup);
    productRepo.addProduct(bread);
    productRepo.addProduct(milk);
    productRepo.addProduct(apple);
    
    // creating promotions
    SpecialOffer applePromo = new SpecialOffer(); 
    applePromo.setDescription("applePromo");
    applePromo.setStart(LocalDate.now());
    applePromo.setEnd(LocalDate.now().plusWeeks(2));
    applePromo.setDiscount(10);
    
    SpecialOffer soupPromo = new SpecialOffer(); 
    soupPromo.setDescription("soupPromo");
    soupPromo.setStart(LocalDate.now());
    soupPromo.setEnd(LocalDate.now().plusWeeks(2));
    soupPromo.setCondition(new Condition(2, 50, "Bread"));
    
    // adding promotions to their correspondent products
    apple.setEspecialOffer(applePromo);
    soup.setEspecialOffer(soupPromo);
  }

  private static void cleanAndTerminate() {
    input.close();
    System.exit(0);
  }
}
