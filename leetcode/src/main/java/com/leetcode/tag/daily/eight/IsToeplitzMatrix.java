package com.leetcode.tag.daily.eight;

/**
 * 766. 托普利茨矩阵
 */
public class IsToeplitzMatrix {
    /**
     * 方法一：遍历
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/toeplitz-matrix/solution/tuo-pu-li-ci-ju-zhen-by-leetcode-solutio-57bb/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] != matrix[i - 1][j - 1]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
