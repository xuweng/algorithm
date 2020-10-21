package com.leetcode.tag.dfs.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1519. 子树中标签相同的节点数
 * <p>
 * 十分钟.十分钟.十分钟
 * <p>
 * 越来越熟练.越来越熟练.越来越熟练.
 */
public class CountSubTrees {
    /**
     * 算法错误
     */
    class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] result;

        public int[] countSubTrees(int n, int[][] edges, String labels) {
            if (edges == null) {
                return new int[0];
            }
            result = new int[n];
            for (int[] edge : edges) {
                map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            }
            dfs(0, labels);

            return result;
        }

        private int dfs(int i, String labels) {
            if (!map.containsKey(i)) {
                result[i] = 1;
                return 1;
            }
            int count = 1;
            for (Integer j : map.get(i)) {
                if (labels.charAt(i) == labels.charAt(j)) {
                    // 不能只比较一个结点.需要比较子树的所有结点.
                    count += dfs(j, labels);
                } else {
                    dfs(j, labels);
                }
            }
            result[i] = count;

            return count;
        }

    }
}
