package com.leetcode.tag.daily;

import org.junit.Test;

public class MinSubArrayLenTest {
  @Test
  public void test() {
    MinSubArrayLen minSubArrayLen = new MinSubArrayLen();

    int s = 11;
    int[] nums = {1, 2, 3, 4, 5};

    minSubArrayLen.minSubArrayLen(s, nums);
  }
}
