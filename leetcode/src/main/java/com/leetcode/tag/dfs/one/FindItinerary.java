package com.leetcode.tag.dfs.one;

import java.util.*;

/**
 * 332. 重新安排行程
 */
public class FindItinerary {
    /**
     * 超出时间限制
     */
    class Solution {
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Set<Integer>> used = new HashMap<>();
        List<String> result;
        List<String> stack = new ArrayList<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                map.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
            }

            map.forEach((k, v) -> {
                Collections.sort(v);
            });

            dfs("JFK", tickets.size());
            result.add(0, "JFK");

            return result;
        }

        public void dfs(String str, int n) {
            if (n == 0) {
                result = result == null ? new ArrayList<>(stack) : result;
                return;
            }
            if (!map.containsKey(str)) {
                return;
            }
            List<String> list = map.get(str);
            for (int i = 0; i < list.size(); i++) {
                if (used.containsKey(str) && used.get(str).contains(i)) {
                    continue;
                }
                stack.add(list.get(i));
                used.computeIfAbsent(str, k -> new HashSet<>()).add(i);
                dfs(list.get(i), n - 1);
                used.get(str).remove(i);
                stack.remove(stack.size() - 1);
            }
        }
    }
}
