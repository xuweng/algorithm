package com.leetcode.tag.contest.two;

/**
 * 5605. 检查两个字符串数组是否相等
 */
public class ArrayStringsAreEqual {
    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            if (word1 == null) {
                return word2 == null;
            }
            if (word1.length == 0) {
                return word2.length == 0;
            }
            String s1 = "";
            for (String s : word1) {
                s1 += s;
            }
            String s2 = "";
            for (String s : word2) {
                s2 += s;
            }
            return s1.equals(s2);
        }
    }
}
