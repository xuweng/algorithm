package com.leetcode.tag.must3.three;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 */
public class SpiralOrder {
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            // 上下左右
            int top = 0;
            int bu = m - 1;
            int left = 0;
            int right = n - 1;

            int index = 0;
            int size = m * n;
            int[] result = new int[size];
            while (index < size) {
                // left到right
                for (int i = left; i <= right; i++) {
                    result[index++] = matrix[top][i];
                }
                top++;
                // top到bu
                for (int i = top; i <= bu; i++) {
                    result[index++] = matrix[i][right];
                }
                right--;
                // right到left
                for (int i = right; i >= left; i--) {
                    result[index++] = matrix[bu][i];
                }
                bu--;
                // bu到top
                for (int i = bu; i >= top; i--) {
                    result[index++] = matrix[i][left];
                }
                left++;
            }

            return result;
        }
    }
}
