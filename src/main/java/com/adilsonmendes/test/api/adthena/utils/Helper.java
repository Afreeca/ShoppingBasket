package com.adilsonmendes.test.api.adthena.utils;

import java.util.Arrays;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class Helper {
  
  public String[] removeFirstItemArray(String[] array) {
    return Arrays.copyOfRange(array, 1, array.length);
  }
  
  public String capitalizeFirstLetter(String str) {
    return StringUtils.capitalize(str);
  }
  
  public double calculatePercentage(double number, int percentage) {
    return (number * (100-percentage)) / 100;
  }
}
