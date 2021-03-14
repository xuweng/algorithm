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

    /**
     * 方法二：移位
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/hamming-distance/solution/yi-ming-ju-chi-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 这里采用右移位，每个位置都会被移动到最右边。移位后检查最右位的位是否为 1 即可。
         * <p>
         * 检查最右位是否为 1，可以使用取模运算（i % 2）或者 AND 操作（i & 1），这两个操作都会屏蔽最右位以外的其他位。
         * <p>
         * 作者：LeetCode
         * 链接：https://leetcode-cn.com/problems/hamming-distance/solution/yi-ming-ju-chi-by-leetcode/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param x
         * @param y
         * @return
         */
        public int hammingDistance(int x, int y) {
            int xor = x ^ y;
            int distance = 0;
            while (xor != 0) {
                //检查最右位的位是否为 1
                if (xor % 2 == 1) {
                    distance += 1;
                }
                // 右移
                xor = xor >> 1;
            }
            return distance;
        }
    }

    /**
     * 方法三：布赖恩·克尼根算法
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/hamming-distance/solution/yi-ming-ju-chi-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int hammingDistance(int x, int y) {
            int xor = x ^ y;
            int distance = 0;
            while (xor != 0) {
                distance += 1;
                // remove the rightmost bit of '1'
                // 原数字 number 的最右边等于 1 的比特会被移除。
                xor = xor & (xor - 1);
            }
            return distance;
        }
    }

}
