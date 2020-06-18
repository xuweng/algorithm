package com.leetcode.tag.daily;

import org.junit.Test;

import java.util.Arrays;

public class StringTest {
  @Test
  public void test() {
    String str = "1-2--3--4-5--6--7";

    String token = "-";

    System.out.println(Arrays.toString(getIndex(str.substring(token.length() + 1), token)));

    System.out.println(str.indexOf("-"));
    System.out.println(str.indexOf("--"));
    System.out.println(str.lastIndexOf("-"));
    System.out.println(str.lastIndexOf("--"));
  }

  private int[] getIndex(String s, String token) {
    char[] chars = s.toCharArray();
    int preIndex = 0;
    for (int i = 1; i < chars.length; i++) {
      if (Character.isDigit(chars[i])) {
        if (token.equals(s.substring(preIndex + 1, i))) {
          return new int[]{preIndex, i};
        }
        preIndex = i;
      }
    }
    return null;
  }
}
