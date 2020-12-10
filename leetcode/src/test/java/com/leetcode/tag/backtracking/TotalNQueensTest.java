package com.leetcode.tag.backtracking;

import com.leetcode.tag.backtracking.one.TotalNQueens;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TotalNQueensTest {
  TotalNQueens totalNQueens = new TotalNQueens();

  @Test
  public void test() {
    int n = 4;
    totalNQueens.totalNQueens(n);

    List<Character[][]> list = totalNQueens.getResult();
    for (Character[][] characters : list) {
      for (Character[] character : characters) {
        System.out.println(Arrays.toString(character));
      }
      System.out.println();
    }
  }
}
