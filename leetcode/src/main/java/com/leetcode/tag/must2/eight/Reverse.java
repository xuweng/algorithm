package com.leetcode.tag.must2.eight;

/**
 * 7. 整数反转
 */
public class Reverse {
    class Solution {
        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
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
