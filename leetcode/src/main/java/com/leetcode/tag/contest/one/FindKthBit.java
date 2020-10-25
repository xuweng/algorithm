package com.leetcode.tag.contest.one;

/**
 * 5484. 找出第 N 个二进制字符串中的第 K 位
 */
public class FindKthBit {
    class Solution {
        public char findKthBit(int n, int k) {
            String s = getBit(n);

            return s.charAt(k - 1);
        }

        private String getBit(int n) {
            if (n == 1) {
                return "0";
            }
            String s = getBit(n - 1);
            char[] chars = s.toCharArray();
            invert(chars);
            reverse(chars, 0, s.length() - 1);

            return s + "1" + new String(chars);
        }

        private void reverse(char[] chars, int i, int j) {
            if (chars == null || chars.length <= 1 || i >= j) {
                return;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            reverse(chars, i + 1, j - 1);
        }

        private void invert(char[] chars) {
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == '0') {
                    chars[i] = '1';
                }
                if (c == '1') {
                    chars[i] = '0';
                }
            }
        }
    }
}
