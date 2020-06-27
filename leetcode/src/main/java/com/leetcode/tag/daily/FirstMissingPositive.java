package com.leetcode.tag.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * 十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>经典题目。经典题目。经典题目。经典题目。经典题目。经典题目。经典题目
 *
 * <p>多做经典题目
 *
 * <p>多做经典题目
 *
 * <p>多做经典题目
 *
 * <p>多做经典题目
 *
 * <p>多做经典题目
 *
 * <p>41. 缺失的第一个正数
 */
public class FirstMissingPositive {
  /**
   * 简单实用
   *
   * <p>简单实用
   *
   * <p>简单实用
   *
   * @param nums
   * @return
   */
  public int firstMissingPositive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 1;
    }
    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      set.add(i);
    }
    for (int i = 1; i < Integer.MAX_VALUE; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return 1;
  }

  /**
   * 我们可以将数组所有的数放入哈希表，随后从 1 开始依次枚举正整数，并判断其是否在哈希表中；
   *
   * <p>我们可以从 1 开始依次枚举正整数，并遍历数组，判断其是否在数组中。
   *
   * <p>如果数组的长度为 N，那么第一种做法的时间复杂度为 O(N)，空间复杂度为 O(N)；
   *
   * <p>第二种做法的时间复杂度为 O(N2)，空间复杂度为O(1)。但它们都不满足题目的要求：时间复杂度为 O(N)，空间复杂度为 O(1)。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public int firstMissingPositive(int[] nums) {
      int n = nums.length;
      for (int i = 0; i < n; ++i) {
        if (nums[i] <= 0) {
          nums[i] = n + 1;
        }
      }
      for (int i = 0; i < n; ++i) {
        int num = Math.abs(nums[i]);
        if (num <= n) {
          nums[num - 1] = -Math.abs(nums[num - 1]);
        }
      }
      for (int i = 0; i < n; ++i) {
        if (nums[i] > 0) {
          return i + 1;
        }
      }
      return n + 1;
    }
  }
}
