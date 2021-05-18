package com.leetcode.tag.must4.one;

/**
 * 面试题 08.11. 硬币
 * <p>
 * 移动指针 移动指针 移动指针
 * <p>
 * 2数和 2数和 2数和
 */
public class WaysToChange {
    class Solution {
        public int waysToChange(int n) {
            int[] coins = new int[]{25, 10, 5, 1};
            int[] dp = new int[n + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int i = coin; i <= n; i++) {
                    dp[i] += dp[i - coin];
                    dp[i] %= 1000000007;
                }
            }

            return dp[n];
        }
    }
}
