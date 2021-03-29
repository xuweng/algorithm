package com.leetcode.tag.must.four;

/**
 * 9. 回文数
 */
public class IsPalindrome {
    class Solution {
        public boolean isPalindrome(int x) {
            // 负数
            if (x < 0) {
                return false;
            }
            // 末尾是0只有0
            if (x % 10 == 0 && x != 0) {
                return false;
            }
            int re = 0;
            while (x > re) {
                re = re * 10 + x % 10;
                x = x / 10;
            }

            // 偶数 奇数
            return x == re || x == re / 10;
        }
    }
}
