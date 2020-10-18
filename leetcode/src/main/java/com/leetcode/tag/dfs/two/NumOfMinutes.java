package com.leetcode.tag.dfs.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1376. 通知所有员工所需的时间
 */
public class NumOfMinutes {
    class Solution {
        int d;
        int result;
        Map<Integer, List<Integer>> map = new HashMap<>();

        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            for (int i = 0; i < manager.length; i++) {
                map.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
            }

            dfs(headID, informTime, 1);

            return result;
        }

        public void dfs(int headID, int[] informTime, int depth) {
            if (!map.containsKey(headID)) {
                return;
            }
            if (depth > d) {
                result += informTime[headID];
            }
            d = depth;
            for (Integer integer : map.get(headID)) {
                dfs(integer, informTime, depth + 1);
            }
        }
    }
}
