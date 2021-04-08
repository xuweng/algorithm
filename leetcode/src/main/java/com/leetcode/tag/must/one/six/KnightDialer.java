package com.leetcode.tag.must.one.six;

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

    /**
     * 作者：8bun
     * 链接：https://leetcode-cn.com/problems/knight-dialer/solution/dpji-yi-hua-di-gui-by-8bun/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 每个数字及可达数字为：
     * 0 -> 4, 6
     * 1 -> 6, 8
     * 2 -> 7, 9
     * 3 -> 4, 8
     * 4 -> 3, 9, 0
     * 5 ->
     * 6 -> 1, 7, 0
     * 7 -> 2, 6
     * 8 -> 1, 3
     * 9 -> 4, 2
     * 设dp[time][num] 表示骑士第time次跳到数字num时组成的不同号码的个数
     * 那么要实现第time次跳到数字num,那么就要保证第time-1次跳到num的可达数字
     * 也就是说dp[time][num]是第time-1跳到num的所有可达数字的dp的总和
     * 最后返回要求dp[N-1][]的值
     */
    class Solution1 {
        //行下标为起点num,每一行的所有数据为可达数字
        private int[][] path = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {4, 2}};
        private static final int MOD = 1000000007;

        public int knightDialer(int N) {
            int[][] dp = new int[N][10];
            for (int num = 0; num < 10; num++) {
                //第0次（跳到）num的不同号码个数为1
                dp[0][num] = 1;
            }

            for (int time = 1; time < N; time++) {
                for (int num = 0; num < 10; num++) {
                    // num->path[num]
                    for (int arrive : path[num]) {
                        // arrive->num
                        dp[time][num] = (dp[time][num] + dp[time - 1][arrive]) % MOD;
                    }
                }
            }
            // 统计每个num
            int res = 0;
            for (int num = 0; num < 10; num++) {
                res = (res + dp[N - 1][num]) % MOD;
            }
            return res;
        }
    }

}
