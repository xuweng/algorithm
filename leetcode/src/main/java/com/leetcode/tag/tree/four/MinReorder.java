package com.leetcode.tag.tree.four;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * 1466. 重新规划路线
 * <p>
 * 十分钟看答案
 * <p>
 * 有向图.保存一个方向.
 * 无向图.保存两个方向.
 */
public class MinReorder {
    static class Solution {
        public int minReorder(int n, int[][] connections) {
            List<List<Integer>> tree = new ArrayList<>();
            //下标表示结点
            for (int i = 0; i < n; i++) {
                tree.add(new ArrayList<>());
            }
            //遍历边数
            for (int i = 0; i < connections.length; i++) {
                //保存边
                tree.get(connections[i][0]).add(i);
                tree.get(connections[i][1]).add(i);
            }
            boolean[] visited = new boolean[connections.length];
            //队列
            Queue<Integer> queue = new LinkedList<>();
            //入队用它
            queue.offer(0);
            int ans = 0;
            while (!queue.isEmpty()) {
                //出队用它
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

    /**
     * 优秀代码
     */
    class Solution1 {
        public int minReorder(int n, int[][] connections) {
            int[] un = IntStream.range(0, n).map(i -> -1).toArray();
            int ans = 0;
            for (int i = 0; i < n - 1; ++i) {
                int p1, p2, cnt1 = 0, cnt2 = 1;
                for (p1 = connections[i][0]; un[p1] != -1; ++cnt1) {
                    p1 = un[p1];
                }
                for (p2 = connections[i][1]; un[p2] != -1; ++cnt2) {
                    p2 = un[p2];
                }
                if (p1 == 0) {
                    ans += cnt2;
                    un[p2] = 0;
                } else if (p2 == 0) {
                    if (un[connections[i][0]] != -1) {
                        ans += cnt1;
                    }
                    un[p1] = 0;
                } else {
                    un[p1] = connections[i][1];
                }
            }
            return ans;
        }
    }
}
