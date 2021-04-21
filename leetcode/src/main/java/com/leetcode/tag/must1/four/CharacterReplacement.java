package com.leetcode.tag.must1.four;

/**
 * 424. 替换后的最长重复字符
 */
public class CharacterReplacement {
    class Solution {
        public int characterReplacement(String s, int k) {
            int left = 0;
            int right = 0;
            int maxCount = 0;
            int result = 0;
            int[] count = new int[26];

            while (right < s.length()) {
                count[s.charAt(right) - 'A']++;
                maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
                while (right - left + 1 > maxCount + k) {
                    count[s.charAt(left) - 'A']--;
                    left++;
                }
                result = Math.max(result, right - left + 1);
                right++;
            }

            return result;
        }
    }
}
