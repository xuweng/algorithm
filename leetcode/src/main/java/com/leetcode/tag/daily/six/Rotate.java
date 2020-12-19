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
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int[][] matrix_new = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix_new[j][n - i - 1] = matrix[i][j];
                }
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = matrix_new[i][j];
                }
            }
        }
    }

}
