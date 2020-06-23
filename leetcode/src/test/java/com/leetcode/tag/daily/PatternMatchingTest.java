package com.leetcode.tag.daily;

import org.junit.Test;

public class PatternMatchingTest {
  @Test
  public void test() {
    PatternMatching patternMatching = new PatternMatching();

    //    String pattern = "abba";
    //    String value = "dogcatcatdog";

    //    String pattern = "abba";
    //    String value = "dogcatcatfish";

    String pattern = "bbbaa";
    // 重复字符不通过
    String value = "xxxxxxy";
    patternMatching.patternMatching(pattern, value);
  }
}
