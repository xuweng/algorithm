package com.leetcode.tag.must2.eight;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * <p>
 * 滚动数组 滚动数组 滚动数组
 * <p>
 * 不合法状态 不合法状态 不合法状态
 */
public class FindNumberIn2DArray {
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            return fen(matrix, target, 0, matrix[0].length - 1);
        }

        private boolean fen(int[][] matrix, int target, int i, int j) {
            // 越界
            if (i >= matrix.length || j < 0) {
                return false;
            }
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                return fen(matrix, target, i, j - 1);
            }
            return fen(matrix, target, i + 1, j);
        }
    }
}
