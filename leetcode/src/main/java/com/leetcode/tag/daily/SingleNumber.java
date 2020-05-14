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

    for (int num : nums) {
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
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

  /**
   * 异或运算有以下三个性质。
   *
   * <p>1、任何数和 0 做异或运算，结果仍然是原来的数
   *
   * <p>2、任何数和其自身做异或运算，结果是 0
   *
   * <p>3、异或运算满足交换律和结合律
   *
   * <p>假设数组中有 2m+1个数，其中有 m个数各出现两次，一个数出现一次。
   *
   * <p>令 a1 ​、a2 ​…、am ​为出现两次的 m个数，am+1 ​为出现一次的数
   *
   * <p>数组中的全部元素的异或运算结果总是可以写成如下形式
   *
   * <p>(a1⊕a1)⊕(a2⊕a2)⊕⋯⊕(am​⊕am)⊕am+1 ​
   *
   * <p>根据性质 2 和性质 1，上式可化简和计算得到如下结果：
   *
   * <p>0⊕0⊕⋯⊕0⊕a m+1=am+1 ​
   */
  class Solution {
    public int singleNumber(int[] nums) {
      for (int i = 1; i < nums.length; i++) {
        nums[0] ^= nums[i];
      }
      return nums[0];
    }
  }
}
