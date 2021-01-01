package com.leetcode.tag.dp.four;

/**
 * 213. 打家劫舍 II
 */
public class Rob4 {
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

        private int rob(int[] nums, int start, int end) {
            int[] dp = new int[nums.length];
            dp[start] = nums[0];
            dp[start + 1] = Math.max(nums[0], nums[1]);

            for (int i = start; i <= end; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }

            return dp[end];
        }
    }
}
