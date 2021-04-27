package com.leetcode.tag.must2;

import java.util.Arrays;

/**
 * 1575. 统计所有可行路径
 * <p>
 * 依赖上一层 倒序
 * <p>
 * 依赖本层 正序
 */
public class CountRoutes {
    class Solution {
        int[][] meno;

        public int countRoutes(int[] locations, int start, int finish, int fuel) {
            meno = new int[locations.length][locations.length];
            for (int[] ints : meno) {
                Arrays.fill(ints, -1);
            }

            return dfs(locations, start, finish, fuel);
        }

        private int dfs(int[] locations, int start, int finish, int fuel) {
            if (meno[start][finish] != -1) {
                return meno[start][finish];
            }
            if (start == finish && fuel >= 0) {
                return 1;
            }
            int need = Math.abs(locations[start] - locations[finish]);
            if (need > fuel) {
                meno[start][finish] = 0;
                return 0;
            }
            int sum = 0;
            for (int i = 0; i < locations.length; i++) {
                if (i == start) {
                    continue;
                }
                int n = Math.abs(locations[i] - locations[start]);
                if (n > fuel) {
                    continue;
                }
                sum += dfs(locations, i, finish, fuel - n);
            }
            meno[start][finish] = sum;
            return sum;
        }
    }
}
