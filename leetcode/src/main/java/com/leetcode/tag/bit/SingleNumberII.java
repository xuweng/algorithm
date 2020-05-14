package com.leetcode.tag.bit;

import java.util.HashSet;
import java.util.Set;

/**
 * 位运算的数学推导
 *
 * <p>137. 只出现一次的数字 II
 *
 * <p>该问题看起来很简单，使用 Set 或 HashMap 可以在O(N) 的时间和 O(N) 的空间内解决。
 *
 * <p>真正的挑战在于 Google 面试官要求使用常数空间解决该问题（最近 6 个月该问题在 Google 上非常流行），测试应聘者是否熟练位操作。
 *
 * <p>作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetcode/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SingleNumberII {
  public int singleNumber(int[] nums) {
    return 0;
  }

  /**
   * 方法一：HashSet 将输入数组存储到 HashSet，然后使用 HashSet 中数字和的三倍与数组之和比较。
   *
   * <p>3×(a+b+c)−(a+a+a+b+b+b+c)=2c
   */
  class Solution {
    public int singleNumber(int[] nums) {
      Set<Long> set = new HashSet<>();
      long sumArray = 0;
      for (int n : nums) {
        sumArray += n;
        set.add((long) n);
      }
      long sumSet = set.stream().mapToLong(s -> s).sum();
      return (int) ((3 * sumSet - sumArray) / 2);
    }
  }
}
