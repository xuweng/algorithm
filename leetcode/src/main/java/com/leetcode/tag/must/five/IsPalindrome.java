package com.leetcode.tag.must.five;

/**
 * 9. 回文数
 */
public class IsPalindrome {
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            if (x % 10 == 0 && x != 0) {
                return false;
            }
            int re = 0;
            while (x > re) {
                re = re * 10 + x % 10;
                x = x / 10;
            }

            return x == re || x == re / 10;
        }
    }
}
