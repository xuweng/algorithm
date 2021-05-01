package com.leetcode.tag.must2.five;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 */
public class CanPartition {
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 != 0) {
                return false;
            }
            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];

            for (int num : nums) {
                for (int i = target; i >= num; i--) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }

            return dp[target];
        }
    }
}
