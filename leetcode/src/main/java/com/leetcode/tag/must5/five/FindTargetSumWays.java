package com.leetcode.tag.must5.five;

import java.util.Arrays;

/**
 * 494. 目标和
 */
public class FindTargetSumWays {
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            // sum=s1+s2
            // target=s1-s2
            // sum+target=2*s1
            int sum = Arrays.stream(nums).sum();
            if (target > sum) {
                return 0;
            }
            if ((sum + target) % 2 != 0) {
                return 0;
            }

            int s = (sum + target) / 2;

            int[] dp = new int[s + 1];
            dp[0] = 1;

            for (int num : nums) {
                for (int i = s; i >= num; i--) {
                    dp[i] += dp[i - num];
                }
            }

            return dp[s];
        }
    }
}
