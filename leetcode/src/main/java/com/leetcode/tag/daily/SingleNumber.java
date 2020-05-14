package com.leetcode.tag.daily;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 10分钟没有思路直接看答案
 *
 * <p>10分钟没有思路直接看答案
 *
 * <p>136. 只出现一次的数字
 *
 * <p>你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class SingleNumber {
  public int singleNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        map.put(nums[i], map.get(nums[i]) + 1);
      } else {
        map.put(nums[i], 1);
      }
    }
    AtomicInteger result = new AtomicInteger();
    map.forEach(
            (k, v) -> {
              if (v == 1) {
                result.set(k);
              }
            });
    return result.get();
  }
}
