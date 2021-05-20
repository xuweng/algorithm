package com.leetcode.tag.must4.four;

/**
 * 5. 最长回文子串
 */
public class LongestPalindrome {
    class Solution {
        public String longestPalindrome(String s) {
            boolean[][] is = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                is[i][i] = true;
            }
            int left = 0;
            int right = 0;
            for (int i = s.length() - 2; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    is[i][j] = s.charAt(i) == s.charAt(j);
                    if (j > i + 1) {
                        is[i][j] = is[i][j] && is[i + 1][j - 1];
                    }
                    if (is[i][j] && j - i > right - left) {
                        left = i;
                        right = j;
                    }
                }
            }

            return s.substring(left, right + 1);
        }
    }
}
