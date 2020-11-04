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

            int index = 0;
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    array[index++] = anInt;
                }
            }

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

    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix/solution/sou-suo-er-wei-ju-zhen-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            if (m == 0) {
                return false;
            }
            int n = matrix[0].length;

            // 二分查找
            int left = 0, right = m * n - 1;
            int pivotElement;
            while (left <= right) {
                int pivotIdx = (left + right) / 2;
                pivotElement = matrix[pivotIdx / n][pivotIdx % n];
                if (target == pivotElement) {
                    return true;
                } else {
                    if (target < pivotElement) {
                        right = pivotIdx - 1;
                    } else {
                        left = pivotIdx + 1;
                    }
                }
            }
            return false;
        }
    }

    /**
     * 作者：ppppjqute
     * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix/solution/java-xing-lie-dan-diao-di-zeng-ju-zhen-sou-suo-by-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0) {
                return false;
            }
            int row = matrix.length - 1;
            int col = matrix[0].length;
            int l = row;
            int r = 0;
            while (l >= 0 && r < col) {
                if (matrix[l][r] == target) {
                    return true;
                } else if (matrix[l][r] > target) {
                    l--;
                } else {
                    r++;
                }
            }
            return false;
        }
    }

}
