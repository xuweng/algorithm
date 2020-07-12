package com.leetcode.tag.contest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 5460. 好数对的数目
 */
public class NumIdenticalPairs {
  class Solution {
    /**
     * 1 <= nums.length <= 100
     *
     * <p>1 <= nums[i] <= 100
     *
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      Map<Integer, Integer> map = new HashMap<>();
      for (int i : nums) {
        map.put(i, map.getOrDefault(i, 0) + 1);
      }
      AtomicInteger count = new AtomicInteger();
      map.forEach((k, v) -> count.addAndGet(sum(v)));
      return count.get();
    }

    private int sum(int i) {
      int sum = 0;
      for (int j = 1; j < i; j++) {
        sum += j;
      }
      return sum;
    }
  }
}
