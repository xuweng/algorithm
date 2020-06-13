package com.leetcode.tag.backtracking;

import org.junit.Test;

public class UniquePathsIIITest {

  @Test
  public void test() {
    UniquePathsIII uniquePathsIII = new UniquePathsIII();

    int[][] grid = {
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 2, -1}
    };

    uniquePathsIII.uniquePathsIII(grid);
  }
}
