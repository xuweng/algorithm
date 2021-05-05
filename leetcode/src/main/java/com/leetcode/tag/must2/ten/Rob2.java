package com.leetcode.tag.must2.ten;

/**
 * 213. 打家劫舍 II
 */
public class Rob2 {
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }

            int max = rob(nums, 0, nums.length - 2);
            int max1 = rob(nums, 1, nums.length - 1);

            return Math.max(max, max1);
        }

        private int rob(int[] nums, int i, int j) {
            int[] dp = new int[nums.length];
            dp[i] = nums[i];
            dp[i + 1] = Math.max(nums[i], nums[i + 1]);

            for (int k = i + 2; k <= j; k++) {
                dp[k] = Math.max(dp[k - 1], dp[k - 2] + nums[k]);
            }

            return dp[j];
        }
    }
}
