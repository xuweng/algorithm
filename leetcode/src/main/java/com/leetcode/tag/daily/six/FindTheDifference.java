package com.leetcode.tag.daily.six;

/**
 * 389. 找不同
 */
public class FindTheDifference {
    class Solution {
        public char findTheDifference(String s, String t) {
            for (int i = 0; i < t.length(); i++) {
                if (!s.contains(String.valueOf(t.charAt(i)))) {
                    return t.charAt(i);
                }
            }
            return t.charAt(0);
        }
    }
}
