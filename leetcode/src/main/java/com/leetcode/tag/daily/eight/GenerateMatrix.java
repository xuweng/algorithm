package com.leetcode.tag.daily.eight;

/**
 * 59. 螺旋矩阵 II
 */
public class GenerateMatrix {
    class Solution {
        public int[][] generateMatrix(int n) {
            int left = 0;
            int top = 0;
            int right = n - 1;
            int bottom = n - 1;

            int[][] result = new int[n][n];
            int length = n * n;
            for (int i = 1; i <= length; ) {
                for (int j = left; j <= right; j++) {
                    result[top][j] = i++;
                }
                top++;
                for (int j = top; j >= bottom; j--) {
                    result[right][j] = i++;
                }
                right--;
                for (int j = right; j >= left; j--) {
                    result[bottom][j] = i++;
                }
                bottom++;
                for (int j = bottom; j >= top; j--) {
                    result[left][j] = i++;
                }
                left++;
            }

            return result;
        }
    }
}
