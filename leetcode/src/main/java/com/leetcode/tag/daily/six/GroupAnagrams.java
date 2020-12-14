package com.leetcode.tag.daily.six;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 49. 字母异位词分组
 */
public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) {
                return new ArrayList<>();
            }
            Map<Integer, List<String>> map = new HashMap<>();
            for (String str : strs) {
                map.computeIfAbsent(get(str), v -> new ArrayList<>()).add(str);
            }
            return new ArrayList<>(map.values());
        }

        private int get(String s) {
            return IntStream.range(0, s.length()).map(s::charAt).sum();
        }
    }
}
