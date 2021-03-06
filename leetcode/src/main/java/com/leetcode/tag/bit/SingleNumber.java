package com.leetcode.tag.bit;

import java.util.HashMap;
import java.util.Map;

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
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    return map.keySet().stream()
            .mapToInt(k -> k)
            .filter(k -> map.get(k) == 1)
            .findFirst()
            .orElse(-1);
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
      int single = 0;
      for (int num : nums) {
        single ^= num;
      }
      return single;
    }
  }
}
