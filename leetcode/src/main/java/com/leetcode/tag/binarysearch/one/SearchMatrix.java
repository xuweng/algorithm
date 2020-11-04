package com.leetcode.tag.binarysearch.one;

/**
 * 74. 搜索二维矩阵
 */
public class SearchMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            int[] array = new int[matrix.length * matrix[0].length];

            return bs(array, 0, array.length - 1, target);
        }

        public boolean bs(int[] array, int low, int high, int target) {
            if (low > high) {
                return false;
            }
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                return bs(array, mid + 1, high, target);
            } else {
                return bs(array, low, mid - 1, target);
            }
        }
    }
}
