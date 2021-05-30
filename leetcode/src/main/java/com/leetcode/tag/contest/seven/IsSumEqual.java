package com.leetcode.tag.contest.seven;

/**
 * 5772. 检查某单词是否等于两单词之和
 */
public class IsSumEqual {
    class Solution {
        public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
            StringBuilder s1 = new StringBuilder();
            for (int i = 0; i < firstWord.length(); i++) {
                s1.append(get(firstWord.charAt(i)));
            }
            StringBuilder s2 = new StringBuilder();
            for (int i = 0; i < secondWord.length(); i++) {
                s2.append(get(secondWord.charAt(i)));
            }
            StringBuilder s3 = new StringBuilder();
            for (int i = 0; i < targetWord.length(); i++) {
                s3.append(get(targetWord.charAt(i)));
            }
            int i1 = Integer.parseInt(s1.toString());
            int i2 = Integer.parseInt(s2.toString());
            int i3 = Integer.parseInt(s3.toString());

            return i1 + i2 == i3;
        }

        private char get(char c) {
            if (c == 'a') {
                return '0';
            } else if (c == 'b') {
                return '1';
            } else if (c == 'c') {
                return '2';
            } else if (c == 'd') {
                return '3';
            } else if (c == 'e') {
                return '4';
            } else if (c == 'f') {
                return '5';
            } else if (c == 'g') {
                return '6';
            } else if (c == 'h') {
                return '7';
            } else if (c == 'i') {
                return '8';
            } else if (c == 'j') {
                return '9';
            }

            return '0';
        }
    }
}
