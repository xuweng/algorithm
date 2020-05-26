package com.leetcode.tag.backtracking;

import org.junit.Test;

import java.util.List;

public class CountNumbersWithUniqueDigitsTest {
  @Test
  public void test() {
    CountNumbersWithUniqueDigits countNumbersWithUniqueDigits = new CountNumbersWithUniqueDigits();
    int n = 3;

    List<String> list = countNumbersWithUniqueDigits.re(n);
    countNumbersWithUniqueDigits.countNumbersWithUniqueDigits(n);
  }

  @Test
  public void test2() {
    CountNumbersWithUniqueDigits.S s = new CountNumbersWithUniqueDigits.S();
    int n = 3;

    s.countNumbersWithUniqueDigits(n);
  }
}
