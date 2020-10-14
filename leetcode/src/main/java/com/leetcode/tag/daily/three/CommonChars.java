package com.leetcode.tag.daily.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1002. 查找常用字符
 */
public class CommonChars {
    class Solution {
        public List<String> commonChars(String[] A) {
            if (A == null) {
                return new ArrayList<>();
            }
            Map<Character, Integer> map = new HashMap<>();
            for (String s : A) {
                for (int i = 0; i < s.length(); i++) {
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                }
            }
            List<String> result = new ArrayList<>();
            map.forEach((k, v) -> {
                int size = v / 3;
                for (int i = 0; i < size; i++) {
                    result.add(String.valueOf(k));
                }
            });

            return result;
        }
    }
}
