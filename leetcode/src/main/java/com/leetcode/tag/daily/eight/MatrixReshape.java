package com.leetcode.tag.daily.eight;

/**
 * 566. 重塑矩阵
 */
public class MatrixReshape {
    /**
     * 方法一：二维数组的一维表示
     * <p>
     * 将二维数组 nums 映射成一个一维数组；
     * <p>
     * 将这个一维数组映射回 r 行 c 列的二维数组。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reshape-the-matrix/solution/zhong-su-ju-zhen-by-leetcode-solution-gt0g/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * flatten 操作
         * <p>
         * (i,j)→i×n+j
         * <p>
         * i=x / n
         * j=x % n
         *
         * @param nums
         * @param r
         * @param c
         * @return
         */
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int m = nums.length;
            int n = nums[0].length;
            if (m * n != r * c) {
                return nums;
            }

            int[][] ans = new int[r][c];
            for (int x = 0; x < m * n; ++x) {
                ans[x / c][x % c] = nums[x / n][x % n];
            }
            return ans;
        }
    }

}
