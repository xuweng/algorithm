package com.leetcode.tag.slidingwindow;

import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 */
public class MinWindow1 {
    static class Solution {
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int left = 0, right = 0;
            int valid = 0;
            // 记录最小覆盖字串的起始索引
            int start = 0;
            // 记录最小覆盖字串长度
            int len = Integer.MAX_VALUE;
            while (right < s.length()) {
                char c = s.charAt(right++);
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
                // 注意是 need.size()
                while (valid == need.size()) {
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }

                    char c1 = s.charAt(left++);
                    if (window.get(c1).equals(need.get(c1))) {
                        valid--;
                    }
                    // 注意位置 放在这里
                    window.put(c1, window.getOrDefault(c1, 0) - 1);
                }
            }

            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
}
