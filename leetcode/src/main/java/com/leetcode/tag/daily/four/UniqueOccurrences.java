package com.leetcode.tag.daily.four;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. 独一无二的出现次数
 */
public class UniqueOccurrences {
    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            if (arr == null || arr.length == 0) {
                return false;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : arr) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            Set<Integer> set = new HashSet<>(map.values());
            return set.size() == map.size();
        }
    }
}
