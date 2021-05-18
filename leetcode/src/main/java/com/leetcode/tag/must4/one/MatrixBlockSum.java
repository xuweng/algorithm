package com.leetcode.tag.must4.one;

/**
 * 1314. 矩阵区域和
 * <p>
 * 移动指针 移动指针 移动指针
 * <p>
 * 前缀和 前缀和 前缀和
 */
public class MatrixBlockSum {
    class Solution {
        public int[][] matrixBlockSum(int[][] mat, int K) {
            int m = mat.length, n = mat[0].length;
            // 二维前缀和
            int[][] sum = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // 上 + 左 - 公共
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
                }
            }
            int[][] res = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 右下角
                    int rx = Math.min(i + K, m - 1);
                    int ry = Math.min(j + K, n - 1);
                    // 左上角
                    int lx = Math.max(i - K, 0);
                    int ly = Math.max(j - K, 0);
                    // -左-上+公共
                    res[i][j] = sum[rx + 1][ry + 1] - sum[rx + 1][ly] - sum[lx][ry + 1] + sum[lx][ly];
                }
            }
            return res;
        }
    }
}
