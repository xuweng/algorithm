package com.leetcode.tag.daily.one;

import org.junit.Test;

public class MaximalSquareTest {
  @Test
  public void replaceSpaceTest() {
    //    char[][] matrix = {
    //      {'1', '0', '1', '0', '0'},
    //      {'1', '0', '1', '1', '1'},
    //      {'1', '0', '0', '1', '0'}
    //    };
    char[][] matrix = {
            {'1', '1'},
            {'1', '0'}
    };
    MaximalSquare maximalSquare = new MaximalSquare();

    System.out.println(maximalSquare.maximalSquare(matrix));
  }
}
