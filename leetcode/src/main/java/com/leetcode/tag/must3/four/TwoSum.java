package com.leetcode.tag.must3.four;

/**
 * 剑指 Offer 57. 和为s的两个数字
 */
public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    return new int[]{nums[left], nums[right]};
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

            return nums;
        }
    }
}
