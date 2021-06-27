package com.leetcode.tag.must6.nine;

import java.util.*;

/**
 * 909. 蛇梯棋
 */
public class SnakesAndLadders {
    /**
     * 方法一：广度优先搜索
     */
    class Solution {
        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            boolean[] vis = new boolean[n * n + 1];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{1, 0});
            while (!queue.isEmpty()) {
                int[] p = queue.poll();
                for (int i = 1; i <= 6; ++i) {
                    int nxt = p[0] + i;
                    if (nxt > n * n) {
                        // 超出边界
                        break;
                    }
                    // 得到下一步的行列
                    int[] rc = id2rc(nxt, n);
                    if (board[rc[0]][rc[1]] > 0) {
                        // 存在蛇或梯子
                        nxt = board[rc[0]][rc[1]];
                    }
                    if (nxt == n * n) {
                        // 到达终点
                        return p[1] + 1;
                    }
                    if (!vis[nxt]) {
                        vis[nxt] = true;
                        // 扩展新状态
                        queue.offer(new int[]{nxt, p[1] + 1});
                    }
                }
            }
            return -1;
        }

        public int[] id2rc(int id, int n) {
            int r = (id - 1) / n, c = (id - 1) % n;
            if (r % 2 == 1) {
                c = n - 1 - c;
            }
            return new int[]{n - 1 - r, c};
        }
    }

    class Solution1 {
        int n;
        int[] nums;

        public int snakesAndLadders(int[][] board) {
            n = board.length;
            if (board[0][0] != -1) {
                return -1;
            }
            nums = new int[n * n + 1];
            boolean isRight = true;
            for (int i = n - 1, idx = 1; i >= 0; i--) {
                for (int j = (isRight ? 0 : n - 1); isRight ? j < n : j >= 0; j += isRight ? 1 : -1) {
                    nums[idx++] = board[i][j];
                }
                isRight = !isRight;
            }
            return bfs();
        }

        int bfs() {
            Deque<Integer> d = new ArrayDeque<>();
            Map<Integer, Integer> m = new HashMap<>();
            d.addLast(1);
            m.put(1, 0);
            while (!d.isEmpty()) {
                int poll = d.pollFirst();
                int step = m.get(poll);
                if (poll == n * n) {
                    return step;
                }
                for (int i = 1; i <= 6; i++) {
                    int np = poll + i;
                    if (np <= 0 || np > n * n) {
                        continue;
                    }
                    if (nums[np] != -1) {
                        np = nums[np];
                    }
                    if (m.containsKey(np)) {
                        continue;
                    }
                    m.put(np, step + 1);
                    d.addLast(np);
                }
            }
            return -1;
        }
    }
}
