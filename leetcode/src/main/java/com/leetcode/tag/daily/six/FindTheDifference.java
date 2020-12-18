package com.leetcode.tag.daily.six;

import java.util.Arrays;

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

    class Solution1 {
        public char findTheDifference(String s, String t) {
            if (s.isEmpty()) {
                return t.charAt(0);
            }
            char[] chars = s.toCharArray();
            char[] chars1 = t.toCharArray();
            Arrays.sort(chars);
            Arrays.sort(chars1);

            for (int i = 0; i < chars1.length; i++) {
                if (i == s.length()) {
                    return chars1[i];
                }
                if (chars[i] != chars1[i]) {
                    return chars1[i];
                }
            }
            return t.charAt(0);
        }
    }
}
