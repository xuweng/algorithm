package com.leetcode.tag.daily.six;

import java.util.Map;
import java.util.TreeMap;

/**
 * 387. 字符串中的第一个唯一字符
 */
public class FirstUniqChar {
    static class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> map = new TreeMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            char c = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Character k = entry.getKey();
                Integer v = entry.getValue();
                if (v == 1) {
                    c = k;
                    break;
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    return i;
                }
            }
            return 0;
        }
    }
}
