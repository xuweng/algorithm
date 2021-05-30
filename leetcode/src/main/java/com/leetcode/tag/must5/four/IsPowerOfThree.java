package com.leetcode.tag.must5.four;

/**
 * 326. 3的幂
 */
public class IsPowerOfThree {
    /**
     * 方法一：循环迭代
     */
    public class Solution {
        public boolean isPowerOfThree(int n) {
            if (n < 1) {
                return false;
            }

            while (n % 3 == 0) {
                n /= 3;
            }

            return n == 1;
        }
    }
}
