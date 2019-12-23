package com.algorithm.study.algorithm.dp;

/**
 * 分数背包问题有最优贪心解
 * <p>
 * 解整数背包问题： 设有n件物品，每件价值记为 P_i ，每件体积记为 V_i
 * 用一个最大容积为V_max的背包，求装入物品的最大价值
 * <p>
 * 用一个数组f[i,v]表示取i件商品填充一个容积为v的背包的最大价值，显然问题的解就是 f[n,V_max]。
 * <p>
 * 对于特例01背包问题（即每件物品最多放1件，否则不放入）的问题，状态转移方程：
 */
public class ZeRoOneBeiBao {
    /**
     * 递归最大价值
     *
     * @param v
     * @param p
     * @param n    数组的下标
     * @param vMax
     * @return
     */
    public static int maxPRe(int[] v, int[] p, int n, int vMax) {
        if (n < 0 || vMax <= 0) {
            return 0;
        }
        if (vMax < v[n]) {
            return maxPRe(v, p, n - 1, vMax);
        }
        return Math.max(maxPRe(v, p, n - 1, vMax), maxPRe(v, p, n - 1, vMax - v[n]) + p[n]);
    }

    /**
     * dp最大价值
     *
     * @param v    体积
     * @param p    价值
     * @param n    物品数量
     * @param vMax 最大容积
     * @return
     */
    public static int maxPDp(int[] v, int[] p, int n, int vMax) {
        int[][] dpMax = new int[n + 1][vMax + 1];
        for (int i = 0; i <= vMax; i++) {
            dpMax[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dpMax[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= vMax; j++) {
                if (v[i - 1] > j) {
                    dpMax[i][j] = dpMax[i - 1][j];
                } else {
                    dpMax[i][j] = Math.max(dpMax[i - 1][j], dpMax[i - 1][j - v[i - 1]] + p[i - 1]);
                }
            }
        }

        return dpMax[n][vMax];

    }
}

