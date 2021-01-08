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

    class Solution1 {
        /**
         * 0-1 背包问题
         *
         * @param W
         * @param N
         * @param wt
         * @param val
         * @return
         */
        int knapsack(int W, int N, int[] wt, int[] val) {
            // vector 全填入 0，base case 已初始化
            int[][] dp = new int[W + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                for (int w = 1; w <= W; w++) {
                    if (w < wt[i - 1]) {
                        // 当前背包容量装不下，只能选择不装入背包
                        dp[i][w] = dp[i - 1][w];
                    } else {
                        // 装入或者不装入背包，择优
                        dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]] + val[i - 1]);
                    }
                }
            }

            return dp[N][W];
        }
    }
}
