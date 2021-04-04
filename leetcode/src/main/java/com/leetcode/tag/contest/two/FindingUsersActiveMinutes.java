package com.leetcode.tag.contest.two;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 5723. 查找用户活跃分钟数
 */
public class FindingUsersActiveMinutes {
    class Solution {
        public int[] findingUsersActiveMinutes(int[][] logs, int k) {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int[] log : logs) {
                Set<Integer> orDefault = map.getOrDefault(log[0], new HashSet<>());
                orDefault.add(log[1]);
                map.put(log[0], orDefault);
            }

            int[] result = new int[k];
            Map<Integer, Integer> map1 = new HashMap<>();
            map.forEach((key, v) -> {
                map1.put(v.size(), map1.getOrDefault(v.size(), 0) + 1);
            });
            map1.forEach((ke, v) -> {
                result[ke - 1] = v;
            });
            return result;
        }
    }
}
