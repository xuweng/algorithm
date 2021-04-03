package com.leetcode.tag.must.seven;

/**
 * 935. 骑士拨号器
 */
public class KnightDialer {
    class Solution {
        //行下标为起点num,每一行的所有数据为可达数字
        private int[][] path = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {4, 2}};
        private static final int MOD = 1000000007;

        public int knightDialer(int N) {
            int[][] dp = new int[N][10];
            for (int num = 0; num < 10; num++) {
                //第0次（跳到）num的不同号码个数为1
                dp[0][num] = 1;
            }

            // 遍历次数
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
