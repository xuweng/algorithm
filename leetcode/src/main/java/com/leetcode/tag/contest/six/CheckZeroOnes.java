package com.leetcode.tag.contest.six;

/**
 * 5763. 哪种连续子字符串更长
 */
public class CheckZeroOnes {
    class Solution {
        public boolean checkZeroOnes(String s) {
            int i = get(s, '1');
            int j = get(s, '0');

            return i > j;
        }

        private int get(String s, char v) {
            int count = 0;
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                if (v == s.charAt(i)) {
                    count++;
                } else {
                    count = 0;
                }
                result = Math.max(result, count);
            }

            return result;
        }
    }
}
