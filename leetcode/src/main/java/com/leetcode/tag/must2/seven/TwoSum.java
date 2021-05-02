package com.leetcode.tag.must2.seven;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * <p>
 * 统计间隙 边缘
 */
public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    return new int[]{nums[left], nums[right]};
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }

            return nums;
        }
    }
}
