package com.adilsonmendes.test.api.adthena;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingBasquetApplication implements CommandLineRunner {
		 
	    private static Logger LOG = LoggerFactory.getLogger(ShoppingBasquetApplication.class);
	 
	    public static void main(String[] args) {
	        LOG.info("STARTING THE APPLICATION");
	        SpringApplication.run(ShoppingBasquetApplication.class, args);
	        LOG.info("APPLICATION FINISHED");
	    }
	  
	    @Override
	    public void run(String... args) {
	        LOG.info("EXECUTING : command line runner");
	  
	    }
}