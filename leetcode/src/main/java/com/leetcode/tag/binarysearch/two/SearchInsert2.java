package com.leetcode.tag.binarysearch.two;

/**
 * 35. 搜索插入位置
 * <p>
 * 初始化 倒序 区间
 */
public class SearchInsert2 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }
}
