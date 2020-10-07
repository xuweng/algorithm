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

    /**
     * 方法一：Hierholzer 算法
     * <p>
     * 我们化简本题题意：给定一个 n 个点 m 条边的图，要求从指定的顶点出发，
     * <p>
     * 经过所有的边恰好一次（可以理解为给定起点的「一笔画」问题），使得路径的字典序最小。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary/solution/zhong-xin-an-pai-xing-cheng-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> itinerary = new LinkedList<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                String src = ticket.get(0), dst = ticket.get(1);
                map.computeIfAbsent(src, k -> new PriorityQueue<>()).offer(dst);
            }
            dfs("JFK");
            Collections.reverse(itinerary);
            return itinerary;
        }

        public void dfs(String curr) {
            while (map.containsKey(curr) && map.get(curr).size() > 0) {
                String tmp = map.get(curr).poll();
                dfs(tmp);
            }
            itinerary.add(curr);
        }
    }

}
