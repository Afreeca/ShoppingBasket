package com.adilsonmendes.test.api.adthena.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HelperTest {

    private Helper helperTest;

    @Before
    public void setUp() {
        helperTest = new Helper();
    }

    @Test
    public void testRemoveFirstItemArray() {
    	String[] array = new String[2];
    	String[] expectedResult = new String[1];

    	array[0] = "test1";
    	array[1] = "test2";
    	expectedResult[0] = "test2";

    	String[] result = helperTest.removeFirstItemArray(array);
    	assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testCapitalizeFirstLetter() {
        final String str = "string";
        final String expectedResult = "String";

        final String result = helperTest.capitalizeFirstLetter(str);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCalculatePercentage() {
        // Setup
        final double number = 25.0;
        final int percentage = 20;
        final double expectedResult = 20.0;

        final double result = helperTest.calculatePercentage(number, percentage);
        assertEquals(expectedResult, result, 0.0001);
    }
}
