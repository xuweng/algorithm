package com.leetcode.tag.must.three;

import java.util.Arrays;

/**
 * 494. 目标和
 */
public class FindTargetSumWays {
    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            // sum=s1+s2
            // s=s1-s2
            // sum+s=2*s1
            int sum = Arrays.stream(nums).sum();
            if (S > sum) {
                return 0;
            }
            if ((sum + S) % 2 != 0) {
                return 0;
            }
            int target = (sum + S) / 2;
            int[] dp = new int[target + 1];
            // 初始化
            dp[0] = 1;
            for (int num : nums) {
                for (int i = target; i >= num; i--) {
                    dp[i] += dp[i - num];
                }
            }

            return dp[target];
        }
    }
}
