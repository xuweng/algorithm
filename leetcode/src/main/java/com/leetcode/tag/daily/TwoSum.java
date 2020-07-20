package com.leetcode.tag.daily;

/**
 * 167. 两数之和 II - 输入有序数组
 */
public class TwoSum {
  /**
   * 升序排列 的有序数组
   *
   * <p>每次排除一个数据
   *
   * <p>不是每次排除一半
   */
  class Solution {
    public int[] twoSum(int[] numbers, int target) {
      int low = 0;
      int high = numbers.length - 1;

      while (low <= high) {
        if (numbers[low] + numbers[high] == target) {
          return new int[]{low + 1, high + 1};
        } else if (numbers[low] + numbers[high] < target) {
          low++;
        } else {
          high--;
        }
      }

      return new int[0];
    }
  }
}
