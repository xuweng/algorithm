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
            // 构建无向图
            for (int[] edge : edges) {
                map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            }
            dfs(0, labels, -1);

            return result;
        }

        private int[] dfs(int i, String labels, int parent) {
            int index = labels.charAt(i) - 'a';
            if (!map.containsKey(i)) {
                // 叶子结点
                result[i] = 1;
                int[] ints = new int[26];
                ints[index] = 1;
                return ints;
            }
            int[] a = new int[26];
            for (Integer j : map.get(i)) {
                if (j == parent) {
                    continue;
                }
                int[] ints = dfs(j, labels, i);
                for (int k = 0; k < ints.length; k++) {
                    a[k] += ints[k];
                }
            }
            a[index]++;
            result[i] = a[index];

            return a;
        }

    }
}
