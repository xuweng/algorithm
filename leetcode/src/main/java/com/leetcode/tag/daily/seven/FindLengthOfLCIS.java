package com.leetcode.tag.daily.seven;

/**
 * 674. 最长连续递增序列
 */
public class FindLengthOfLCIS {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int max = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = nums[i - 1] >= nums[i] ? 1 : dp[i - 1] + 1;

                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }
}
