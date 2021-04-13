package com.leetcode.tag.must.seven;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 */
public class CanPartition {
    class Solution {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 != 0) {
                return false;
            }
            sum = sum / 2;

            boolean[] dp = new boolean[sum + 1];
            // 初始化
            dp[0] = true;
            for (int num : nums) {
                for (int i = sum; i >= num; i--) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }

            return dp[sum];
        }
    }
}
