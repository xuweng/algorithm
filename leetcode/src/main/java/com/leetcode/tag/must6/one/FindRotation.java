package com.leetcode.tag.must6.one;

import java.util.Arrays;

/**
 * 5776. 判断矩阵经轮转后是否一致
 */
public class FindRotation {
    class Solution {
        int temp;

        /**
         * 将一个矩阵 90 度顺时针旋转 4 次，旋转后的矩阵与本身一致
         * <p>
         * 模拟 4 次将 mat 90 度顺时针旋转的操作，并在每次旋转操作后与 target 比较
         *
         * @param mat
         * @param target
         * @return
         */
        public boolean findRotation(int[][] mat, int[][] target) {
            int n = mat.length;
            // 最多旋转 4 次
            for (int k = 0; k < 4; ++k) {
                // 旋转操作
                for (int i = 0; i < n / 2; ++i) {
                    for (int j = 0; j < (n + 1) / 2; ++j) {
                        temp = mat[i][j];
                        mat[i][j] = mat[n - 1 - j][i];
                        mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j];
                        mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i];
                        mat[j][n - 1 - i] = temp;
                    }
                }

                if (mat == target) {
                    return true;
                }
            }
            return false;
        }
    }

    class Solution1 {
        public boolean findRotation(int[][] mat, int[][] target) {
            int t = 0;
            int n = mat.length;
            int[][] res = new int[n][n];
            while (t <= n) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        res[i][j] = mat[n - 1 - j][i];
                    }
                }
                for (int i = 0; i < n; i++) {
                    System.arraycopy(res[i], 0, mat[i], 0, n);
                }
                if (Arrays.deepEquals(res, target)) {
                    return true;
                }
                t++;
            }
            return false;
        }
    }
}
