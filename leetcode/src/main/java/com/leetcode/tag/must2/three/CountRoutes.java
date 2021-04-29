package com.leetcode.tag.must2.three;

import java.util.Arrays;

/**
 * 1575. 统计所有可行路径
 * <p>
 * 可变参数
 * <p>
 * 坐标 步数
 * <p>
 * 索引 油量
 */
public class CountRoutes {
    class Solution {
        int[][] meno;
        int mod = 1000000007;

        public int countRoutes(int[] locations, int start, int finish, int fuel) {
            meno = new int[locations.length][fuel + 1];
            for (int[] ints : meno) {
                Arrays.fill(ints, -1);
            }

            return dfs(locations, start, finish, fuel);
        }

        private int dfs(int[] locations, int start, int finish, int fuel) {
            if (fuel < 0) {
                return 0;
            }
            int need = Math.abs(locations[start] - locations[finish]);
            if (need > fuel) {
                meno[start][fuel] = 0;
                return 0;
            }
            if (meno[start][fuel] != -1) {
                return meno[start][fuel];
            }
            // 可以从finish出发
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
