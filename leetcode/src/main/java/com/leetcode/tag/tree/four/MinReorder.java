package com.leetcode.tag.tree.four;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1466. 重新规划路线
 * <p>
 * 十分钟看答案
 * <p>
 * 有向图.保存一个方向.
 * 无向图.保存两个方向.
 */
public class MinReorder {
    class Solution {
        public int minReorder(int n, int[][] connections) {
            List<List<Integer>> tree = new ArrayList<>();
            //下标表示结点
            for (int i = 0; i < n; i++) {
                tree.add(new ArrayList<>());
            }
            //遍历边数
            for (int i = 0; i < connections.length; i++) {
                tree.get(connections[i][0]).add(i);
                tree.get(connections[i][1]).add(i);
            }
            boolean[] visited = new boolean[connections.length];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            int ans = 0;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                List<Integer> connection = tree.get(node);
                for (Integer idx : connection) {
                    if (visited[idx]) {
                        continue;
                    }
                    visited[idx] = true;
                    int a = connections[idx][0];
                    int b = connections[idx][1];
                    ans += a == node ? 1 : 0;
                    queue.offer(a == node ? b : a);
                }
            }

            return ans;
        }
    }
}
