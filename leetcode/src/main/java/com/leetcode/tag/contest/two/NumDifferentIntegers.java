package com.leetcode.tag.contest.two;

import java.util.HashSet;
import java.util.Set;

/**
 * 5713. 字符串中不同整数的数目
 */
public class NumDifferentIntegers {
    static class Solution {
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
            String[] s1 = s.split(" ");
            Set<Integer> stringSet = new HashSet<>();
            Set<String> strings = new HashSet<>();
            for (String s2 : s1) {
                if (s2.isEmpty()) {
                    continue;
                }
                try {
                    int i = Integer.parseInt(s2);
                    stringSet.add(i);
                } catch (Exception e) {
                    strings.add(s2);
                }
            }

            return stringSet.size() + strings.size();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String word = "a123bc34d8ef34";

        s.numDifferentIntegers(word);
    }
}
