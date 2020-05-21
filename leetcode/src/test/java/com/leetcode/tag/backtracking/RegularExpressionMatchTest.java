package com.leetcode.tag.backtracking;

import org.junit.Test;

public class RegularExpressionMatchTest {
  @Test
  public void test() {
    RegularExpressionMatch regularExpressionMatch = new RegularExpressionMatch();

    String s = "aa";
    String p = "a*";

    System.out.println(regularExpressionMatch.isMatch(s, p));
  }
}
