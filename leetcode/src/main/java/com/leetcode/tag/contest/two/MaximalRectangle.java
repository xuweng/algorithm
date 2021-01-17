package com.leetcode.tag.contest.two;

/**
 * 85. 最大矩形
 * <p>
 * 知道思路后，直接写代码
 * <p>
 * 一定要自己写一遍 一定要自己写 一定要自己写 一定要自己写
 */
public class MaximalRectangle {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            int[][] ints = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    ints[i][j] = Integer.parseInt(String.valueOf(matrix[i][j]));
                }
            }

            for (int i = 0; i < ints.length; i++) {
                for (int j = 1; j < ints[0].length; j++) {
                    if (ints[i][j] == 1) {
                        ints[i][j] = ints[i][j - 1] + 1;
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < ints.length; i++) {
                for (int j = 0; j < ints[0].length; j++) {
                    int height = 1;
                    int min = ints[i][j];
                    for (int k = i; k >= 0; k--) {
                        min = Math.min(min, ints[k][j]);

                        max = Math.max(max, min * height);
                        height++;
                    }
                }
            }

            return max;
        }
    }
}
