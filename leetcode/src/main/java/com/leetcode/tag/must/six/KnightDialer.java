package com.leetcode.tag.must.six;

import java.util.Arrays;

/**
 * 935. 骑士拨号器
 */
public class KnightDialer {
    /**
     * f(start, n) 可以从 f(x, n - 1) 转移而来，其中 x 是任意一个可以一步跳到 start 的数字
     * <p>
     * 。例如当 start = 1，时，x 可以为 6 或 8，因此有 f(1, n) = f(6, n - 1) + f(8, n - 1)。
     */
    class Solution {
        public int knightDialer(int N) {
            int MOD = 1_000_000_007;
            int[][] moves = new int[][]{
                    {4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0},
                    {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};

            int[][] dp = new int[2][10];
            Arrays.fill(dp[0], 1);
            for (int hops = 0; hops < N - 1; ++hops) {
                Arrays.fill(dp[~hops & 1], 0);
                for (int node = 0; node < 10; ++node) {
                    for (int nei : moves[node]) {
                        dp[~hops & 1][nei] += dp[hops & 1][node];
                        dp[~hops & 1][nei] %= MOD;
                    }
                }
            }

            long ans = 0;
            for (int x : dp[~N & 1]) {
                ans += x;
            }
            return (int) (ans % MOD);
        }
    }
}
