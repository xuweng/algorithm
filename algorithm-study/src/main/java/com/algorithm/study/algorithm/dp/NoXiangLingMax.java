package com.algorithm.study.algorithm.dp;

/**
 * 选择不相邻的数的和的最大值
 */
public class NoXiangLingMax {
    //备忘录
    private static int[] memo = new int[100];
    private static int init = -1;

    static {
        for (int i = 0; i < memo.length - 1; i++) {
            memo[i] = init;
        }
    }

    /**
     * 递归不相邻的数的和的最大值
     *
     * @param a
     * @param i a的下标
     * @return
     */
    public static int noXiangLingMaxRe(int[] a, int i) {
        if (i <= 0) {
            return a[i];
        }
        if (i == 1) {
            return Math.max(a[i - 1], a[i]);
        }
        return Math.max(noXiangLingMaxRe(a, i - 2) + a[i], noXiangLingMaxRe(a, i - 1));
    }

    /**
     * 算法导论里面的代码模板
     * <p>
     * 递归备忘录不相邻的数的和的最大值
     *
     * @param a
     * @param i a的下标
     * @return
     */
    public static int noXiangLingMaxReMemo(int[] a, int i) {
        if (memo[i] != init) {
            return memo[i];
        }
        if (i <= 0) {
            memo[i] = a[i];
            return memo[i];
        }
        if (i == 1) {
            memo[i] = Math.max(a[i - 1], a[i]);
            return memo[i];
        }
        memo[i] = Math.max(noXiangLingMaxReMemo(a, i - 2) + a[i], noXiangLingMaxReMemo(a, i - 1));
        return memo[i];
    }

    /**
     * dp不相邻的数的和的最大值
     * 一维dp
     * 二维dp
     * 最多三维dp
     * dp[i]:前i个最大值
     *
     * @param a
     * @return
     */
    public static int noXiangLingMaxDp(int[] a) {
        int i = a.length;
        if (i <= 0) {
            return 0;
        }
        if (i <= 1) {
            return a[0];
        }
        if (i <= 2) {
            return Math.max(a[0], a[1]);
        }
        int[] dpMax = new int[i + 1];
        dpMax[0] = 0;
        dpMax[1] = a[0];
        dpMax[2] = Math.max(a[0], a[1]);

        for (int j = 2; j <= i; j++) {
            dpMax[j] = Math.max(dpMax[j - 2] + a[j - 1], dpMax[i - 1]);
        }

        return dpMax[i];
    }
}
