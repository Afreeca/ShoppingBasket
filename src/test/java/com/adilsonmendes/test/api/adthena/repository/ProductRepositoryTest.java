package com.adilsonmendes.test.api.adthena.repository;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import com.adilsonmendes.test.api.adthena.model.Product;
import com.adilsonmendes.test.api.adthena.utils.Helper;

public class ProductRepositoryTest {

    private ProductRepository productRepo;

    @Before
    public void setUp() {
        productRepo = new ProductRepository();
        Product productA = new Product(1, "ProductA", 0.55, "tin");
        Product productB = new Product(1, "ProductB", 1.00, "tin");
        
        productRepo.addProduct(productA);
        productRepo.addProduct(productB);
        
        productRepo.helper = mock(Helper.class);
    }


    @Test
    public void testIsProductExists() {
        final String name = "productA";
        when(productRepo.helper.capitalizeFirstLetter(name)).thenReturn("ProductA");

        final boolean result = productRepo.isProductExists(name);
        assertTrue(result);
    }


    @Test
    public void testPrint() {
        // Setup

        // Run the test
        productRepo.print();

        // Verify the results
    }
}
