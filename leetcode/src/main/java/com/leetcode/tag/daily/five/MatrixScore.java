package com.leetcode.tag.daily.five;

/**
 * 861. 翻转矩阵后的得分
 */
public class MatrixScore {
    /**
     * 方法一：贪心
     * <p>
     * 为了得到最高的分数，矩阵的每一行的最左边的数都必须为 1
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix/solution/fan-zhuan-ju-zhen-hou-de-de-fen-by-leetc-cxma/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int matrixScore(int[][] A) {
            int m = A.length, n = A[0].length;
            int ret = m * (1 << (n - 1));

            for (int j = 1; j < n; j++) {
                int nOnes = 0;
                for (int[] ints : A) {
                    if (ints[0] == 1) {
                        nOnes += ints[j];
                    } else {
                        nOnes += (1 - ints[j]); // 如果这一行进行了行反转，则该元素的实际取值为 1 - A[i][j]
                    }
                }
                int k = Math.max(nOnes, m - nOnes);
                ret += k * (1 << (n - j - 1));
            }
            return ret;
        }
    }

}
