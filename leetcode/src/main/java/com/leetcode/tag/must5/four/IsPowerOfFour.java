package com.leetcode.tag.must5.four;

/**
 * 342. 4的幂
 */
public class IsPowerOfFour {
    class Solution {
        public boolean isPowerOfFour(int n) {
            if (n < 1) {
                return false;
            }
            while (n % 4 == 0) {
                n = n / 4;
            }

            return n == 1;
        }
    }

    /**
     * 如果 n 是 4 的幂，那么 n 的二进制表示中有且仅有一个 1，
     * <p>
     * 并且这个 1 出现在从低位开始的第偶数个二进制位上（这是因为这个 1 后面必须有偶数个 0）。
     * <p>
     * 这里我们规定最低位为第 0 位，例如 n=16 时，n 的二进制表示为
     * <p>
     * (10000)_2
     * <p>
     * 唯一的 1 出现在第 4 个二进制位上，因此 n 是 4 的幂。
     */
    class Solution1 {
        public boolean isPowerOfFour(int n) {
            // 如果 n 是 4 的幂，那么 n 一定也是 2 的幂
            // mask=(10101010101010101010101010101010)2
            return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
        }
    }
}
