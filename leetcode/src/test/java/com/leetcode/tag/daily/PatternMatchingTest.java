package com.leetcode.tag.daily;

import org.junit.Test;

public class PatternMatchingTest {
  PatternMatching patternMatching = new PatternMatching();

  @Test
  public void test() {
    String pattern = "abba";
    String value = "dogcatcatdog";

    System.out.println(patternMatching.patternMatching(pattern, value));
  }

  @Test
  public void test1() {

    String pattern = "abba";
    String value = "dogcatcatfish";

    System.out.println(patternMatching.patternMatching(pattern, value));
  }

  @Test
  public void test2() {

    String pattern = "aaaa";
    String value = "dogcatcatdog";

    System.out.println(patternMatching.patternMatching(pattern, value));
  }

  @Test
  public void test3() {

    String pattern = "abba";
    String value = "dogdogdogdog";

    System.out.println(patternMatching.patternMatching(pattern, value));
  }

  @Test
  public void test4() {

    String pattern = "bbbaa";
    // 重复字符不通过
    String value = "xxxxxxy";

    System.out.println(patternMatching.patternMatching(pattern, value));
  }
}
