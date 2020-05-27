package com.leetcode.tag.daily;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubarraysDivByKTest {
  @Test
  public void test() {
    SubarraysDivByK subarraysDivByK = new SubarraysDivByK();

    int[] A = new int[]{4, 5, 0, -2, -3, 1};
    int K = 5;

    subarraysDivByK.subarraysDivByK(A, K);
  }

  @Test
  public void test1() {
    SubarraysDivByK.S subarraysDivByK = new SubarraysDivByK.S();

    int[] A = new int[]{4, 5, 0, -2, -3, 1};
    int K = 5;

    assertEquals(9, subarraysDivByK.sum(A, 0, 1));
    assertEquals(7, subarraysDivByK.subarraysDivByK(A, K));
  }
}
