package com.leetcode.tag.must2.seven;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * <p>
 * 反转 反转 反转 反转 反转
 */
public class LengthOfLongestSubstring {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int left = 0;
            int right = 0;
            int result = 0;
            int[] ints = new int[26];

            while (right < s.length()) {
                ints[s.charAt(right) - 'a']++;
                while (ints[s.charAt(right) - 'a'] > 1) {
                    ints[s.charAt(left) - 'a']--;
                    left++;
                }
                result = Math.max(result, right - left + 1);
                right++;
            }

            return result;
        }
    }
}
