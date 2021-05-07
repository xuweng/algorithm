package com.leetcode.tag.must4;

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
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
                }
            }
            int[][] res = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //大框upper的x、y
                    int ux = Math.min(i + K + 1, m);
                    int uy = Math.min(j + K + 1, n);
                    //小框down的x、y
                    int dx = Math.max(i - K, 0);
                    int dy = Math.max(j - K, 0);
                    //与计算前缀和一样，sum[ux][dy] 与 sum[dx][uy]分别为横条和竖条的面积
                    res[i][j] = sum[ux][uy] - sum[ux][dy] - sum[dx][uy] + sum[dx][dy];
                }
            }
            return res;
        }
    }
}
