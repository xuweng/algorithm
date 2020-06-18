package com.leetcode.tag.daily;

import org.junit.Test;

import java.util.Arrays;

public class StringTest {
  @Test
  public void test() {
    String str = "1-2--3--4-5--6--7";

    String token = "-";

    System.out.println(Arrays.toString(getIndex(str, token)));

    System.out.println(str.indexOf("-"));
    System.out.println(str.indexOf("--"));
    System.out.println(str.lastIndexOf("-"));
    System.out.println(str.lastIndexOf("--"));
  }

  private int[] getIndex(String s, String token) {
    char[] chars = s.toCharArray();
    int preIndex = chars.length - 1;
    for (int i = chars.length - 2; i >= 0; i--) {
      if (Character.isDigit(chars[i])) {
        if (token.equals(s.substring(i + 1, preIndex))) {
          return new int[]{i, preIndex};
        }
        preIndex = i;
      }
    }
    return null;
  }
}
