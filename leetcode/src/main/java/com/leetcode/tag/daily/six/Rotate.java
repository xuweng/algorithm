package com.leetcode.tag.daily.six;

/**
 * 48. 旋转图像
 */
public class Rotate {
    /**
     * 方法一：使用辅助数组
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/rotate-image/solution/xuan-zhuan-tu-xiang-by-leetcode-solution-vu3m/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 对于矩阵中第 i 行的第 j 个元素，在旋转后，它出现在倒数第 i 列的第 j 个位置。
         * <p>
         * 对于矩阵中的元素 matrix[row][col]，在旋转后，它的新位置为 matrix[col][n−row−1]
         *
         * @param matrix
         */
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            //使用辅助数组
            int[][] matrixNew = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrixNew[j][n - i - 1] = matrix[i][j];
                }
            }
            for (int i = 0; i < n; ++i) {
                System.arraycopy(matrixNew[i], 0, matrix[i], 0, n);
            }
        }
    }

}
