package com.leetcode.tag.must1.two;

/**
 * 389. 找不同
 */
public class FindTheDifference {
    class Solution {
        public char findTheDifference(String s, String t) {
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                result = result ^ s.charAt(i);
            }
            for (int i = 0; i < t.length(); i++) {
                result = result ^ t.charAt(i);
            }

            return (char) result;
        }
    }
}
