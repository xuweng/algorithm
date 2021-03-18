package com.leetcode.tag.binarysearch.two;

/**
 * 35. 搜索插入位置
 */
public class SearchInsert1 {
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
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return left;
        }
    }

    class Solution1 {
        public int searchInsert(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }
}
