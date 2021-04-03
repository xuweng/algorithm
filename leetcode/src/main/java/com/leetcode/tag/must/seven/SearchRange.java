package com.leetcode.tag.must.seven;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null) {
                return new int[]{};
            }
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    int i = mid;
                    int j = mid;
                    while (i >= 0 && nums[i] == target) {
                        i--;
                    }
                    while (j < nums.length && nums[j] == target) {
                        j++;
                    }
                    return new int[]{i + 1, j - 1};
                }
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return new int[]{-1, -1};
        }
    }
}
