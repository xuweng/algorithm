package com.leetcode.tag.must.nine;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }
            int first = first(nums, target);
            if (first == -1) {
                return new int[]{-1, -1};
            }
            int last = last(nums, target);

            return new int[]{first, last};
        }

        private int last(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right + 1 - left) / 2;
                if (nums[mid] <= target) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            return left;
        }

        private int first(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (nums[left] == target) {
                return left;
            }

            return -1;
        }
    }
}
