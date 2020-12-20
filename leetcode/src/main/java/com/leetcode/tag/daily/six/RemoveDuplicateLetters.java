package com.leetcode.tag.daily.six;

/**
 * 316. 去除重复字母
 */
public class RemoveDuplicateLetters {
    class Solution {
        public String removeDuplicateLetters(String s) {
            if (s == null || s.isEmpty()) {
                return s;
            }
            char[] chars = new char[26];
            for (int i = 0; i < s.length(); i++) {
                chars[s.charAt(i) - 'a']++;
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != 0) {
                    result.append(chars[i]);
                }
            }
            return result.toString();
        }
    }
}
