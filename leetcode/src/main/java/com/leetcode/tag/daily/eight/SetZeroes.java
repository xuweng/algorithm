package com.leetcode.tag.daily.eight;

/**
 * 73. 矩阵置零
 */
public class SetZeroes {
    class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }
            int m = matrix.length;
            int n = matrix[0].length;

            boolean[][] flag = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0 && !flag[i][j]) {
                        for (int k = 0; k < n; k++) {
                            if (matrix[i][k] != 0) {
                                flag[i][k] = true;
                            }
                            matrix[i][k] = 0;
                        }
                        for (int k = 0; k < m; k++) {
                            if (matrix[k][j] != 0) {
                                flag[k][j] = true;
                            }
                            matrix[k][j] = 0;
                        }
                    }
                }
            }
        }
    }

    /**
     * 方法一：使用标记数组
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes/solution/ju-zhen-zhi-ling-by-leetcode-solution-9ll7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;

            boolean[] row = new boolean[m];
            boolean[] col = new boolean[n];
            // 首先遍历该数组一次，如果某个元素为 0，那么就将该元素所在的行和列所对应标记数组的位置置为true
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = col[j] = true;
                    }
                }
            }
            // 再次遍历该数组，用标记数组更新原数组
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (row[i] || col[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

}
