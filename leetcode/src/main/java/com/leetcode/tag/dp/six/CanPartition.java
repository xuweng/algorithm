package com.leetcode.tag.dp.six;

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
            // 和为奇数时，不可能划分成两个和相等的集合
            if (sum % 2 != 0) {
                return false;
            }
            sum = sum / 2;
            boolean[][] dp = new boolean[nums.length + 1][sum + 1];
            // 重点 base case
            for (int i = 0; i <= nums.length; i++) {
                //因为背包没有空间的时候，就相当于装满了
                dp[i][0] = true;
            }
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 1; j <= sum; j++) {
                    if (j < nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    }
                }
            }

            return dp[nums.length][sum];
        }
    }
}
