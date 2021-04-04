package com.leetcode.tag.contest.two;

/**
 * 5722. 截断句子
 */
public class TruncateSentence {
    class Solution {
        public String truncateSentence(String s, int k) {
            if (s == null || s.isEmpty()) {
                return s;
            }
            int index = 0;
            int count = 0;
            for (int i = 0; i < s.length() && count < k; i++) {
                if (s.charAt(i) == ' ') {
                    count++;
                }
                index = i;
            }
            index = index == s.length() - 1 ? s.length() : index;

            return s.substring(0, index);
        }
    }
}
