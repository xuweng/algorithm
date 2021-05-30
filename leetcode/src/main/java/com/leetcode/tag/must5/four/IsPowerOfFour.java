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
}
