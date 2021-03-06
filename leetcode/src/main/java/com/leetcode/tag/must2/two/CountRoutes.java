package com.leetcode.tag.must2.two;

import java.util.Arrays;

/**
 * 1575. 统计所有可行路径
 */
public class CountRoutes {
    class Solution {
        int mod = 1000000007;
        int[][] meno;

        public int countRoutes(int[] locations, int start, int finish, int fuel) {
            int n = locations.length;
            meno = new int[n][fuel + 1];

            for (int[] ints : meno) {
                Arrays.fill(ints, -1);
            }

            return dfs(locations, start, finish, fuel);
        }

        private int dfs(int[] locations, int start, int finish, int fuel) {
            if (meno[start][fuel] != -1) {
                return meno[start][fuel];
            }
            int need = Math.abs(locations[start] - locations[finish]);
            if (need > fuel) {
                meno[start][fuel] = 0;
                return 0;
            }
            // 当前位置在finish,有油量还能继续走
            int sum = start == finish ? 1 : 0;
            for (int i = 0; i < locations.length; i++) {
                if (i == start) {
                    continue;
                }
                int n = Math.abs(locations[i] - locations[start]);
                if (n > fuel) {
                    continue;
                }
                sum += dfs(locations, i, finish, fuel - n);
                sum %= mod;
            }
            meno[start][fuel] = sum;
            return sum;
        }
    }

    class Solution1 {
        int mod = 1000000007;

        public int countRoutes(int[] locations, int start, int finish, int fuel) {
            int n = locations.length;
            int[][] dp = new int[n][fuel + 1];
            // 初始化在finish
            for (int i = 0; i <= fuel; i++) {
                dp[finish][i] = 1;
            }
            // 先枚举油量
            for (int i = 0; i <= fuel; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (j == k) {
                            continue;
                        }
                        int need = Math.abs(locations[j] - locations[k]);
                        if (need > i) {
                            continue;
                        }
                        dp[j][i] += dp[k][i - need];
                        dp[j][i] %= mod;
                    }
                }
            }

            return dp[start][fuel];
        }
    }
}
