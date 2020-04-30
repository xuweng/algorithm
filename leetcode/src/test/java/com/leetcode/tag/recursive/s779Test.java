package com.leetcode.tag.recursive;

import org.junit.Test;

public class s779Test {
  @Test
  public void replaceSpaceTest() {
    int[][] array = {{1, 1}, {2, 1}, {2, 2}, {4, 5}};
    s779 s779 = new s779();
    for (int i = 0; i < array.length; i++) {
      System.out.println(s779.kthGrammar(array[i][0], array[i][1]));
    }
  }
}
