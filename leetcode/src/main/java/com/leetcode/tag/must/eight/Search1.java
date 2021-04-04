package com.leetcode.tag.must.eight;

/**
 * 81. 搜索旋转排序数组 II
 */
public class Search1 {
    class Solution {
        public boolean search(int[] nums, int target) {
            if (nums == null) {
                return false;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                    right--;
                } else if (nums[left] <= nums[mid]) {
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[right]) {
                        right = mid + 1;
                    } else {
                        left = mid - 1;
                    }
                }
            }

            return false;
        }
    }
}
