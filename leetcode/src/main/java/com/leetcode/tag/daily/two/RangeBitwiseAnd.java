package com.leetcode.tag.daily.two;

/**
 * 201. 数字范围按位与
 * <p>
 * 公共前缀
 * <p>
 * 问题的本质是求解m和n的最长公共前缀，如果m==n直接返回
 * <p>
 * 暂时放弃位运算
 * <p>
 * 规律
 * <p>
 * 对所有数字执行按位与运算的结果是所有对应二进制字符串的公共前缀再用零补上后面的剩余位
 * <p>
 * 找规律就惨了。万物皆有规律。
 * <p>
 * 万物皆有规律。万物皆有规律。万物皆有规律。
 */
public class RangeBitwiseAnd {
    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            return 0;
        }
    }

    /**
     * 方法一：位移
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/solution/shu-zi-fan-wei-an-wei-yu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int rangeBitwiseAnd(int m, int n) {
            int shift = 0;
            // 找到公共前缀
            while (m < n) {
                m >>= 1;
                n >>= 1;
                ++shift;
            }
            return m << shift;
        }
    }

    /**
     * 方法二：Brian Kernighan 算法
     * <p>
     * 清除二进制串中最右边的 1
     * <p>
     * number 和 number−1 之间进行按位与运算后，number 中最右边的 1 会被抹去变成 0
     *
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/solution/shu-zi-fan-wei-an-wei-yu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int rangeBitwiseAnd(int m, int n) {
            while (m < n) {
                // 抹去最右边的 1
                n = n & (n - 1);
            }
            return n;
        }
    }

}
