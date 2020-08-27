package com.leetcode.tag.daily.two;

import java.util.*;

/**
 * 332. 重新安排行程
 */
public class FindItinerary {
    class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {
            return null;
        }
    }

    /**
     * 求解欧拉回路 / 欧拉通路
     * <p>
     * 给定一个 n 个点 m 条边的图，要求从指定的顶点出发，经过所有的边恰好一次（可以理解为给定起点的「一笔画」问题），使得路径的字典序最小
     * <p>
     * 这种「一笔画」问题与欧拉图或者半欧拉图有着紧密的联系
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
                if (!map.containsKey(src)) {
                    map.put(src, new PriorityQueue<>());
                }
                map.get(src).offer(dst);
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
