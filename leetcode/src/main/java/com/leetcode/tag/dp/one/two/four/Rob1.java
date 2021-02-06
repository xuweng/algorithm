package com.leetcode.tag.dp.one.two.four;

/**
 * 213. 打家劫舍 II
 */
public class Rob1 {
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
            int max1 = rob(nums, 0, nums.length - 2);
            int max2 = rob(nums, 1, nums.length - 1);

            return Math.max(max1, max2);
        }

        private int rob(int[] nums, int start, int end) {
            int[] dp = new int[nums.length];
            dp[start] = nums[start];
            dp[start + 1] = Math.max(nums[start], nums[start + 1]);
            for (int i = start + 2; i <= end; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }

            return dp[end];
        }
    }
}
