package com.leetcode.tag.must.one.ten;

import java.util.Arrays;

/**
 * 494. 目标和
 * <p>
 * 排列去重 排列去重 排列去重
 */
public class FindTargetSumWays {
    /**
     * sum=s1+s2
     * <p>
     * s1-s2=s
     * <p>
     * s=s1-s2
     * <p>
     * sum+s=2*s1
     */
    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int sum = Arrays.stream(nums).sum();
            if (S > sum) {
                // 防止内存溢出
                return 0;
            }
            int target = sum + S;
            if (target % 2 != 0) {
                return 0;
            }
            sum = target / 2;
            int[] dp = new int[sum + 1];
            dp[0] = 1;
            for (int num : nums) {
                for (int i = sum; i >= num; i--) {
                    dp[i] += dp[i - num];
                }
            }

            return dp[sum];
        }
    }
}
