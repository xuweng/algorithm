package com.leetcode.tag.contest.two;

/**
 * 5713. 字符串中不同整数的数目
 */
public class NumDifferentIntegers {
    class Solution {
        public int numDifferentIntegers(String word) {
            if (word == null || word.isEmpty()) {
                return 0;
            }
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (Character.isLetter(chars[i])) {
                    chars[i] = ' ';
                }
            }
            String s = new String(chars);

            return s.split(" ").length;
        }
    }
}
