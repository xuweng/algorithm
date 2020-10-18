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
        Map<Integer, List<Integer>> map = new HashMap<>();

        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            for (int i = 0; i < manager.length; i++) {
                map.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
            }

            return dfs(headID, informTime);
        }

        public int dfs(int headID, int[] informTime) {
            int result = informTime[headID];
            if (!map.containsKey(headID)) {
                return result;
            }
            for (Integer integer : map.get(headID)) {
                result += dfs(integer, informTime);
            }
            return result;
        }
    }
}
