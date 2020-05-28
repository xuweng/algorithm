package com.leetcode.tag.backtracking;

import org.junit.Test;

public class GetMaximumGoldTest {
  int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};

  @Test
  public void test() {
    GetMaximumGold getMaximumGold = new GetMaximumGold();

    getMaximumGold.getMaximumGold(grid);
  }
}
