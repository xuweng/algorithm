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

        private int[] dfs(int i, String labels) {
            if (!map.containsKey(i)) {
                result[i] = 1;
                int[] ints = new int[26];
                ints[labels.charAt(i) - 'a'] = 1;
                return ints;
            }
            int[] a = new int[26];
            for (Integer j : map.get(i)) {
                int[] ints = dfs(j, labels);
                for (int k = 0; k < ints.length; k++) {
                    a[k] += ints[k];
                }
            }
            a[labels.charAt(i) - 'a']++;
            result[i] = a[labels.charAt(i)];

            return a;
        }

    }
}
