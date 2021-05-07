package com.leetcode.tag.must4;

/**
 * 523. 连续的子数组和
 */
public class CheckSubarraySum {
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int[] sum = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int s = sum[j + 1] - sum[i];
                    if (s % k == 0) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
