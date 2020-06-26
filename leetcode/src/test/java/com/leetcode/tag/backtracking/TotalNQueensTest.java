package com.leetcode.tag.backtracking;

import org.junit.Test;

public class TotalNQueensTest {
  TotalNQueens totalNQueens = new TotalNQueens();

  @Test
  public void test() {
    int n = 4;
    totalNQueens.totalNQueens(n);
    System.out.println(totalNQueens.getResult());
  }
}
