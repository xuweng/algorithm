package com.leetcode.tag.contest.must.one;

/**
 * 5799. 最美子字符串的数目
 */
public class WonderfulSubstrings {
    class Solution {
        public long wonderfulSubstrings(String word) {
            if (word == null || word.isEmpty()) {
                return 0;
            }
            int count = 0;

            for (int i = 0; i < word.length(); i++) {
                for (int j = i; j < word.length(); j++) {
                    if (is(word.substring(i, j + 1))) {
                        count++;
                    }
                }
            }

            return count;
        }

        private boolean is(String s) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            int n = 0;
            for (int i : count) {
                if (i % 2 != 0) {
                    n++;
                }
                if (n > 1) {
                    return false;
                }
            }

            return true;
        }
    }
}
