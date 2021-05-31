package com.leetcode.tag.must5.six;

import java.util.Arrays;

/**
 * 1883. 准时抵达会议现场的最小跳过休息次数
 */
public class MinSkips {
    class Solution {
        public int minSkips(int[] dist, int speed, int m) {
            int n = dist.length;
            double eps = 1e-8;
            // 表示经过了dist[0] 到dist[i−1] 的 i 段道路，并且跳过了 j 次的最短用时
            double[][] f = new double[n + 1][n + 1];
            for (double[] doubles : f) {
                Arrays.fill(doubles, Double.MAX_VALUE);
            }
            f[0][0] = 0;

            for (int i = 1; i <= n; i++) {
                double t = (double) dist[i - 1] / speed;
                for (int j = 0; j <= i; j++) {
                    if (j <= i - 1) {
                        // 没有跳过
                        f[i][j] = Math.ceil(f[i - 1][j] + t - eps);
                    }
                    if (j > 0) {
                        // 跳过
                        f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + t);
                    }
                }
            }
            for (int i = 0; i <= n; i++) {
                if (f[n][i] <= m) {
                    return i;
                }
            }
            return -1;
        }
    }
}
