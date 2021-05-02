package com.leetcode.tag.must2.seven;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 */
public class ReverseWords1 {
    class Solution {
        public String reverseWords(String s) {
            String[] s1 = s.trim().split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = s1.length - 1; i >= 0; i--) {
                if (" ".equals(s1[i])) {
                    continue;
                }
                stringBuilder.append(s1[i]);
                if (i > 0) {
                    stringBuilder.append(" ");
                }
            }

            return stringBuilder.toString();
        }
    }
}
