package com.leetcode.tag.must1.five;

/**
 * 363. 矩形区域不超过 K 的最大数值和
 */
public class MaxSumSubmatrix {
    class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] sum = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // 左 + 右 - 公共
                    sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
            int max = Integer.MIN_VALUE;
            // 枚举 左(i,j)
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // 枚举 右(p,q)
                    for (int p = i; p <= m; p++) {
                        for (int q = j; q <= n; q++) {
                            // （i,j）-> (p,q)
                            int s = sum[p][q] - sum[p][j - 1] - sum[i - 1][q] + sum[i - 1][j - 1];
                            if (s <= k) {
                                max = Math.max(max, s);
                            }
                        }
                    }
                }
            }

            return max;
        }
    }
}
