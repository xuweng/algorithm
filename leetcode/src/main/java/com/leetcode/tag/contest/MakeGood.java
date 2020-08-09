package com.leetcode.tag.contest;

/**
 * 5483. 整理字符串
 */
public class MakeGood {
    /**
     * 算法思路错误
     * <p>
     * 算法思路错误
     */
    class Solution {
        public String makeGood(String s) {
            int i = firstUpperCase(s);
            if (i == -1 || s.length() < 2) {
                return s;
            }
            if (s.length() == 2) {
                return "";
            }
            if (i == 0 && Character.isUpperCase(s.charAt(1))) {
                return makeGood(s.substring(i + 2));
            }
            if (i != 0) {
                return makeGood(s.substring(0, i));
            }
            return null;

        }

        public int firstUpperCase(String s) {
            if (s == null) {
                return -1;
            }
            for (int i = 0; i < s.length(); i++) {
                if (Character.isUpperCase(s.charAt(i))) {
                    return i;
                }
            }

            return -1;
        }
    }
}
