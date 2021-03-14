package com.leetcode.tag.hot;

/**
 * 461. 汉明距离
 */
public class HammingDistance {
    /**
     * 方法一：内置位计数功能
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/hamming-distance/solution/yi-ming-ju-chi-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 计算 x 和 y 之间的汉明距离，可以先计算 x XOR y，然后统计结果中等于 1 的位数
         *
         * @param x
         * @param y
         * @return
         */
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }

}
