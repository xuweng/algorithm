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
            int need = Math.abs(locations[start] - locations[finish]);
            if (need > fuel) {
                meno[start][finish] = 0;
                return 0;
            }
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
            }
            meno[start][finish] = sum;
            return sum;
        }
    }

    class Solution1 {
        int mod = 1000000007;

        // 缓存器：用于记录「特定状态」下的结果
        // cache[i][fuel] 代表从位置 i 出发，当前剩余的油量为 fuel 的前提下，到达目标位置的「路径数量」
        int[][] cache;

        public int countRoutes(int[] ls, int start, int end, int fuel) {
            int n = ls.length;

            // 初始化缓存器
            // 之所以要初始化为 -1
            // 是为了区分「某个状态下路径数量为 0」和「某个状态尚未没计算过」两种情况
            cache = new int[n][fuel + 1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(cache[i], -1);
            }

            return dfs(ls, start, end, fuel);
        }

        /**
         * 计算「路径数量」
         *
         * @param ls   入参 locations
         * @param u    当前所在位置（ls 的下标）
         * @param end  目标哦位置（ls 的下标）
         * @param fuel 剩余油量
         * @return 在位置 u 出发，油量为 fuel 的前提下，到达 end 的「路径数量」
         */
        int dfs(int[] ls, int u, int end, int fuel) {
            // 如果缓存中已经有答案，直接返回
            if (cache[u][fuel] != -1) {
                return cache[u][fuel];
            }

            // 如果一步到达不了，说明从位置 u 不能到达 end 位置
            // 将结果 0 写入缓存器并返回
            int need = Math.abs(ls[u] - ls[end]);
            if (need > fuel) {
                cache[u][fuel] = 0;
                return 0;
            }

            int n = ls.length;
            // 计算油量为 fuel，从位置 u 到 end 的路径数量
            // 由于每个点都可以经过多次，如果 u = end，那么本身就算一条路径
            int sum = u == end ? 1 : 0;
            for (int i = 0; i < n; i++) {
                if (i != u) {
                    need = Math.abs(ls[i] - ls[u]);
                    if (fuel >= need) {
                        sum += dfs(ls, i, end, fuel - need);
                        sum %= mod;
                    }
                }
            }
            cache[u][fuel] = sum;
            return sum;
        }
    }
}
