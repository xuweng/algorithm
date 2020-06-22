package com.leetcode.tag.daily;

import org.junit.Test;

public class PatternMatchingTest {
  @Test
  public void test() {
    PatternMatching patternMatching = new PatternMatching();

    String pattern = "abba";
    String value = "dogcatcatdog";
    patternMatching.patternMatching(pattern, value);
  }
}
