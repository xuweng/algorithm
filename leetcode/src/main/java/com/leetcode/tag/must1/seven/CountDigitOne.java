package com.leetcode.tag.must1.seven;

/**
 * 233. 数字 1 的个数
 */
public class CountDigitOne {
    class Solution {
        public int countDigitOne(int n) {
            int countr = 0;
            for (long i = 1; i <= n; i *= 10) {
                long divider = i * 10;
                countr += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
            }
            return countr;
        }
    }
}
