package com.leetcode.tag.must1.three;

/**
 * 424. 替换后的最长重复字符
 */
public class CharacterReplacement {
    class Solution {
        public int characterReplacement(String s, int k) {
            int[] count = new int[26];
            int max = 0;
            int left = 0;
            int right = 0;
            int maxCount = 0;
            while (right < s.length()) {
                count[s.charAt(right) - 'A']++;
                maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
                while (right - left + 1 > maxCount + k) {
                    count[s.charAt(left) - 'A']--;
                    left++;
                }
                max = Math.max(max, right - left + 1);
                right++;
            }

            return max;
        }
    }
}
