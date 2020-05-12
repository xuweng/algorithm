package com.leetcode.tag.divide;

import org.junit.Test;

public class LeastNumbersTest {
  @Test
  public void test() {
    int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
    int k = 8;
    LeastNumbers leastNumbers = new LeastNumbers();

    System.out.println(leastNumbers.getLeastNumbers(arr, k));
  }
}
