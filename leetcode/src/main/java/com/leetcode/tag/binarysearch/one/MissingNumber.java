package com.leetcode.tag.binarysearch.one;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 */
public class MissingNumber {
    static class Solution {
        public int missingNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            return bs(nums, 0, nums.length - 1);
        }

        private int bs(int[] nums, int low, int high) {
            if (low >= high) {
                return high + 1;
            }
            int mid = low + (high - low) / 2;
            if (nums[mid] != mid) {
                return mid;
            } else if (nums[mid] - nums[low] == mid - low) {
                return bs(nums, mid + 1, high);
            } else {
                return bs(nums, low, mid - 1);
            }
        }
    }
}
