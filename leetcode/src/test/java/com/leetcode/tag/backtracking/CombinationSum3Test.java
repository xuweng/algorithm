package com.leetcode.tag.backtracking;

import org.junit.Test;

public class CombinationSum3Test {
  int k = 4;
  int n = 1000;

  @Test
  public void test() {
    CombinationSum3 combinationSum3 = new CombinationSum3();

    combinationSum3.combinationSum3(k, n);

    System.out.println(CombinationSum3.reCount);
  }

  @Test
  public void test1() {
    CombinationSum3.Solution combinationSum3 = new CombinationSum3.Solution();

    combinationSum3.combinationSum3(k, n);

    System.out.println(CombinationSum3.reCount);
  }
}
