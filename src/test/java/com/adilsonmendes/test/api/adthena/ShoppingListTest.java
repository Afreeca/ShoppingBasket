package com.adilsonmendes.test.api.adthena;

import com.adilsonmendes.test.api.adthena.model.Product;
import com.adilsonmendes.test.api.adthena.repository.ProductRepository;
import com.adilsonmendes.test.api.adthena.utils.Helper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ShoppingListTest {

    @Mock
    private ProductRepository mockProductRepo;
    @Mock
    private Helper mockHelper;

    @InjectMocks
    private ShoppingList shoppingListUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testProcess() {
        // Setup
        final ArrayList<Product> list = new ArrayList<>(Arrays.asList());
        when(mockProductRepo.getProduct("name")).thenReturn(null);
        when(mockHelper.calculatePercentage(0.0, 0)).thenReturn(0.0);
        when(mockHelper.capitalizeFirstLetter("str")).thenReturn("result");

        // Run the test
        shoppingListUnderTest.Process(list);

        // Verify the results
    }

    @Test
    public void testIsValidateShoppingCommand() {
        final String[] list = "PriceBasket productA productB".split(" ");

        final boolean result = shoppingListUnderTest.isValidateShoppingCommand(list);
        assertTrue(result);
    }
    
    @Test
    public void testIsValidateShoppingCommandUknown() {
        final String[] list = "Basketprice productA productB".split(" ");

        final boolean result = shoppingListUnderTest.isValidateShoppingCommand(list);
        assertFalse(result);
    }
}
