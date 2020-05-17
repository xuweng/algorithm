package com.leetcode.tag.divide;

import org.junit.Test;

public class ReversePairsTest {
  @Test
  public void test() {
    //    int[] nums = {1, 3, 2, 3, 1};
    int[] nums = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
    ReversePairs reversePairs = new ReversePairs();
    System.out.println(2147483646 > 2 * 2147483647);
    System.out.println(2147483646 > (long) 2 * 2147483647);
    System.out.println(1 > 2 * 2147483647);
    System.out.println(1 > (long) 2 * 2147483647);
    System.out.println(reversePairs.reversePairs(nums));
  }
}
