package com.leetcode.tag.binarysearch.two;

/**
 * 300. 最长上升子序列
 * <p>
 * 连续。不连续。
 * <p>
 * 数组的环计算。
 */
public class LengthOfLIS {
    class Solution {
        /**
         * 连续:f(i)只需要看f(i-1)
         * <p>
         * 不连续:f(1)、f(2).....f(i-1)
         *
         * @param nums
         * @return
         */
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int result = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                result = Math.max(result, dp[i]);
            }
            return result;
        }
    }
}
