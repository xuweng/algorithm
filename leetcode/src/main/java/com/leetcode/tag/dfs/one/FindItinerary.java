package com.leetcode.tag.dfs.one;

import java.util.*;

/**
 * 332. 重新安排行程
 */
public class FindItinerary {
    class Solution {
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> used = new HashMap<>();
        List<String> result = new ArrayList<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                map.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
            }

            map.forEach((k, v) -> {
                Collections.sort(v);
            });

            dfs("JFK ");

            return result;
        }

        public void dfs(String str) {
            if (!map.containsKey(str)) {
                return;
            }
            result.add(str);
            List<String> list = map.get(str);
            for (int i = 0; i < list.size(); i++) {
                if (used.containsKey(str) && used.get(str).equals(i)) {
                    continue;
                }
                used.put(str, i);
                dfs(list.get(i));
            }
        }
    }
}
