package com.leetcode.tag.must2.five;

import java.util.Arrays;

/**
 * 1575. 统计所有可行路径
 * <p>
 * 可变参数 可变参数 可变参数
 */
public class CountRoutes {
    class Solution {
        int mod = 1000000007;
        int[][] meno;

        public int countRoutes(int[] locations, int start, int finish, int fuel) {
            int len = locations.length;
            meno = new int[len][fuel + 1];
            for (int[] ints : meno) {
                Arrays.fill(ints, -1);
            }

            return dfs(locations, start, finish, fuel);
        }

        private int dfs(int[] locations, int start, int finish, int fuel) {
            if (fuel < 0) {
                return 0;
            }
            if (meno[start][fuel] != -1) {
                return meno[start][fuel];
            }
            int need = Math.abs(locations[start] - locations[finish]);
            if (need > fuel) {
                meno[start][fuel] = 0;
                return 0;
            }
            int sum = start == finish ? 1 : 0;
            for (int i = 0; i < locations.length; i++) {
                if (i == start) {
                    continue;
                }
                int n = Math.abs(locations[start] - locations[i]);
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
}
