package com.adilsonmendes.test.api.adthena.utils;

import java.util.Arrays;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class Helper {
  
  public <T> T[] removeFirstItemArray(T[] array) {
    return Arrays.copyOfRange(array, 1, array.length);
  }
  
  public String capitalizeFirstLetter(String str) {
    return StringUtils.capitalize(str);
  }
}
