package com.leetcode.tag.backtracking;

import org.junit.Test;

public class CountArrangementTest {
  CountArrangement countArrangement = new CountArrangement();

  @Test
  public void test() {
    int N = 2;
    countArrangement.countArrangement(N);
  }

  @Test
  public void test1() {
    int N = 3;
    countArrangement.countArrangement(N);
  }
}
