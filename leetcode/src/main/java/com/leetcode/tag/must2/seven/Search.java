package com.leetcode.tag.must2.seven;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
public class Search {
    class Solution {
        public int search(int[] nums, int target) {
            int left = getLeft(nums, target);
            int right = getRight(nums, target);

            return right - left + 1;
        }

        private int getLeft(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (target <= mid) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return right;
        }

        private int getRight(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (target >= mid) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            return right;
        }
    }
}
