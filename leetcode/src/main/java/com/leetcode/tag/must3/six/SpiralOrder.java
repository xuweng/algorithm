package com.leetcode.tag.must3.six;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 */
public class SpiralOrder {
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new int[0];
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int top = 0;
            int bu = m - 1;
            int left = 0;
            int right = n - 1;

            int[] result = new int[m * n];
            int start = 0;
            int end = m * n;

            while (start < end) {
                // 左到右
                for (int i = left; i <= right && start < end; i++) {
                    result[start++] = matrix[top][i];
                }
                top++;
                // 上到下
                for (int i = top; i <= bu && start < end; i++) {
                    result[start++] = matrix[i][right];
                }
                right--;
                // 右到左
                for (int i = right; i >= left && start < end; i--) {
                    result[start++] = matrix[bu][i];
                }
                bu--;
                // 下到上
                for (int i = bu; i >= top && start < end; i--) {
                    result[start++] = matrix[i][left];
                }
                left++;
            }

            return result;
        }
    }
}
