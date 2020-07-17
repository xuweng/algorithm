package com.leetcode.tag.daily;

/**
 * 35. 搜索插入位置
 */
public class SearchInsert {
  /** 心里，脑海里测试所有示例 */
  class Solution {
    /**
     * 假设数组中无重复元素
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      return re(nums, target, 0, nums.length - 1);
    }

    public int re(int[] nums, int target, int low, int high) {
      if (low >= high) {
        return nums[low] >= target ? low : low + 1;
      }
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        return re(nums, target, mid + 1, high);
      }
      return re(nums, target, low, mid - 1);
    }
  }
}
