package com.leetcode.tag.dp.nine;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 * <p>
 * 数学思维 指针移动
 * <p>
 * 数学思维 指针移动
 * <p>
 * 数学思维 指针移动
 * <p>
 * 一次做对 一次做对
 */
public class CanPartition1 {
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
            boolean[][] dp = new boolean[nums.length + 1][sum + 1];
            for (int i = 0; i <= nums.length; i++) {
                dp[i][0] = true;
            }
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 1; j <= sum; j++) {
                    if (j < nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    }
                }
            }

            return dp[nums.length][sum];
        }
    }
}
