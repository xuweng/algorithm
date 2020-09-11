package com.leetcode.tag.tree.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1443. 收集树上所有苹果的最少时间
 */
public class MinTime {
    class Solution {
        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            Map<Integer, List<Integer>> map = new HashMap<>(64);
            for (int[] edge : edges) {
                List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
                list.add(edge[1]);
                map.put(edge[0], list);
            }

            int result = back(0, map, hasApple);

            return result * 2;
        }

        private int back(int root, Map<Integer, List<Integer>> map, List<Boolean> hasApple) {
            List<Integer> list = map.get(root);
            if (list == null) {
                return -1;
            }
            if (hasApple.get(root)) {
                return 0;
            }
            int result = 0;
            for (Integer integer : list) {
                int i = back(integer, map, hasApple);
                if (i >= 0) {
                    result = i + 1;
                }
            }

            return result;
        }
    }
}
