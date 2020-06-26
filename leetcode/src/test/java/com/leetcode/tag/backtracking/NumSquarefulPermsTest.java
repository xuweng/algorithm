package com.leetcode.tag.backtracking;

import org.junit.Test;

public class NumSquarefulPermsTest {
  NumSquarefulPerms numSquarefulPerms = new NumSquarefulPerms();

  @Test
  public void test() {
    int[] A = {2, 2, 2};
    numSquarefulPerms.numSquarefulPerms(A);
  }

  @Test
  public void test1() {
    int[] A = {1, 17, 8};
    numSquarefulPerms.numSquarefulPerms(A);
  }
}
