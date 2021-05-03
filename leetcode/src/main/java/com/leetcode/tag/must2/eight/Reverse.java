package com.leetcode.tag.must2.eight;

/**
 * 7. 整数反转
 */
public class Reverse {
    class Solution {
        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                // Integer.MAX_VALUE = 2147483647
                // Integer.MAX_VALUE / 10 = 214748364
                // rev > 214748364,rev = 214748365,214748366,214748367,214748368,214748369
                // 214748365 * 10 = 2147483650 > 2147483647
                if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                // 末尾数字 digit
                int digit = x % 10;
                rev = rev * 10 + digit;
                x /= 10;
            }
            return rev;
        }
    }
}
