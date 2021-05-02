package com.leetcode.tag.must2.seven;

/**
 * 58. 最后一个单词的长度
 */
public class LengthOfLastWord {
    class Solution {
        public int lengthOfLastWord(String s) {
            int a = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) != ' ') {
                    a++;
                } else if (a != 0) {
                    return a;
                }

            }
            return a;
        }
    }

    class Solution1 {
        public int lengthOfLastWord(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            s = s.trim();
            int count = 0;
            for (int i = s.length() - 1; i >= 0 && s.charAt(i) != ' '; i--) {
                count++;
            }
            return count;
        }
    }
}
