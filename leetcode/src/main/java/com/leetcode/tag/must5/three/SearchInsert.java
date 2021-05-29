package com.leetcode.tag.must5.three;

/**
 * 35. 搜索插入位置
 */
public class SearchInsert {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] < target) {
                    right = mid + 1;
                } else {
                    left = mid - 1;
                }
            }

            return right;
        }
    }
}
