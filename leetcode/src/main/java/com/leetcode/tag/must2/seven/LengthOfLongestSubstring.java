package com.leetcode.tag.must2.seven;

import java.util.HashMap;
import java.util.Map;

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
            Map<Character, Integer> map = new HashMap<>();

            while (right < s.length()) {
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                while (map.get(s.charAt(left)) > 1) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    left++;
                }
                result = Math.max(result, right - left + 1);
                right++;
            }

            return result;
        }
    }
}
