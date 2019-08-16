package com.adilsonmendes.test.api.adthena;

import java.util.Scanner;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.adilsonmendes.test.api.adthena.repository.ProductRepository;
import com.adilsonmendes.test.api.adthena.repository.PromotionRepository;

@SpringBootApplication
public class ShoppingBasquetApplication implements CommandLineRunner {
		 
	    private static Logger LOG = LoggerFactory.getLogger(ShoppingBasquetApplication.class);
	    Scanner input;
	    
	    @Autowired
	    ProductRepository productRepo;
	    
	    @Autowired
	    PromotionRepository promotionRepo;
	 
	    public static void main(String[] args) {
	        LOG.info("STARTING THE APPLICATION");
	        
	        SpringApplication app = new SpringApplication(ShoppingBasquetApplication.class);
	        app.setBannerMode(Banner.Mode.OFF);
	        app.run(args);
	        
	        LOG.info("APPLICATION FINISHED");
	    }
	  
	    @Override
	    public void run(String... args) {
	        LOG.info("EXECUTING : command line runner");
	        
	       input = new Scanner(System.in);
            int test = input.nextInt();
            LOG.info("VIVA: " + test);
  
            cleanAndClose();
	    }
	    
	    private void cleanAndClose() {
          input.close();
          System.exit(0);
	    }
}
