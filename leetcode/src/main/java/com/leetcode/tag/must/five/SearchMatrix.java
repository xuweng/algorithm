package com.leetcode.tag.must.five;

/**
 * 74. 搜索二维矩阵
 */
public class SearchMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int left = 0;
            int right = m * n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int x = matrix[mid / n][mid % n];
                if (x == target) {
                    return true;
                }
                if (x < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return false;
        }
    }
}
