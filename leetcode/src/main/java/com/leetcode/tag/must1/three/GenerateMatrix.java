package com.leetcode.tag.must1.three;

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
                for (int j = top; j <= bottom; j++) {
                    result[j][right] = i++;
                }
                right--;
                for (int j = right; j >= left; j--) {
                    result[bottom][j] = i++;
                }
                bottom--;
                for (int j = bottom; j >= top; j--) {
                    result[j][left] = i++;
                }
                left++;
            }

            return result;
        }
    }

    class Solution1 {
        public int[][] generateMatrix(int n) {
            // 定义当前左右上下边界 l,r,t,b
            int l = 0, r = n - 1, t = 0, b = n - 1;
            int[][] mat = new int[n][n];
            int num = 1, tar = n * n;
            while (num <= tar) {
                // 左到右
                // left to right.
                for (int i = l; i <= r; i++) {
                    mat[t][i] = num++;
                }
                // 上边界++
                t++;
                // 上到下
                // top to bottom.
                for (int i = t; i <= b; i++) {
                    mat[i][r] = num++;
                }
                // 右边界--
                r--;
                // 右到左
                // right to left.
                for (int i = r; i >= l; i--) {
                    mat[b][i] = num++;
                }
                // 下边界--
                b--;
                // 下到上
                // bottom to top.
                for (int i = b; i >= t; i--) {
                    mat[i][l] = num++;
                }
                // 左边界++
                l++;
            }
            return mat;
        }
    }
}
