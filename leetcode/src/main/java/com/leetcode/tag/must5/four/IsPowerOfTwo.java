package com.leetcode.tag.must5.four;

/**
 * 231. 2 的幂
 * <p>
 * 前缀和 前缀和 前缀和
 */
public class IsPowerOfTwo {
    /**
     * 方法一：二进制表示
     */
    class Solution {
        public boolean isPowerOfTwo(int n) {
            //  n 是正整数，并且 n 的二进制表示中仅包含 1 个 1
            return n > 0 && (n & (n - 1)) == 0;
        }
    }

    /**
     * 判断是否为最大 2 的幂的约数
     */
    class Solution1 {
        // 最大的 2 的幂为 2^{30} = 10737418242
        static final int BIG = 1 << 30;

        public boolean isPowerOfTwo(int n) {
            return n > 0 && BIG % n == 0;
        }
    }
}
