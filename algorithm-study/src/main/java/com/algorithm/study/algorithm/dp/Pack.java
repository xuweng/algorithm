package com.algorithm.study.algorithm.dp;

/**
 * 背包九讲
 */
public class Pack {
    //最大容量
    private static int V = 10;
    //5个背包
    private static int N = 5;
    //每个背包容量
    private static int[] C = new int[N];
    //每个背包价值
    private static int[] W = new int[N];

    static {
        for (int i = 1; i <= N; i++) {
            C[i - 1] = i;
        }
        for (int i = 0; i <= V; i++) {
            W[i - 1] = i;
        }
    }

    /**
     * 基础01背包
     *
     * @return
     */
    public static int zeroOne() {
        int[][] dpMax = initTwoDpMax();

        for (int i = 1; i <= N; i++) {
            //从1初始化
            for (int j = 1; j <= V; j++) {
                if (C[i - 1] < j) {
                    //第i个放不下
                    dpMax[i][j] = dpMax[i - 1][j];
                } else {
                    dpMax[i][j] = Math.max(dpMax[i - 1][j], dpMax[i - 1][j - C[i - 1]] + W[i - 1]);
                }
            }
        }
        return dpMax[N][V];
    }

    /**
     * 注意数组下标。
     * 大神代码。大神代码。大神代码。大神代码。大神代码。大神代码。大神代码。大神代码。大神代码。大神代码。
     *
     * @return
     */
    public static int zeroOne1() {
        int[][] dpMax = initTwoDpMax();

        for (int i = 1; i <= N; i++) {
            //从能放得下初始化
            for (int j = C[i - 1]; j <= V; j++) {
                dpMax[i][j] = Math.max(dpMax[i - 1][j], dpMax[i - 1][j - C[i - 1]] + W[i - 1]);
            }
        }

        return dpMax[N][V];
    }

    /**
     * 一维状态dp
     *
     * @return
     */
    public static int zeroOne2() {
        int[] dpMax = initOneDpMax();
        for (int i = 1; i <= N; i++) {
            common(dpMax, C[i - 1], W[i - 1]);
        }

        return dpMax[V];
    }

    /**
     * 公共
     *
     * @param F
     * @param C 某个物品体积
     * @param W 某个物品价值
     */
    private static void common(int[] F, int C, int W) {
        for (int i = V; i >= C; i--) {
            F[i] = Math.max(F[i], F[i - C] + W);
        }
    }

    /**
     * 初始化二维状态dp
     *
     * @return
     */
    private static int[][] initTwoDpMax() {
        int[][] dpMax = new int[N + 1][V + 1];

        for (int i = 0; i <= V; i++) {
            dpMax[0][i] = 0;
        }
        for (int i = 0; i <= N; i++) {
            dpMax[i][0] = 0;
        }

        return dpMax;
    }

    /**
     * 初始化一维状态dp
     *
     * @return
     */
    private static int[] initOneDpMax() {
        int[] dpMax = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            dpMax[i] = 0;
        }

        return dpMax;
    }

}
