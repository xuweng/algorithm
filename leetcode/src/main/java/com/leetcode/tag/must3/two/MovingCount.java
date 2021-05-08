package com.leetcode.tag.must3.two;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * <p>
 * 一个配匹完 移动指针 移动指针 移动指针
 * <p>
 * 一个配匹完 一个配匹完 一个配匹完
 */
public class MovingCount {
    class Solution {
        public int movingCount(int m, int n, int k) {
            if (k == 0) {
                return 1;
            }
            Queue<int[]> queue = new LinkedList<>();
            // 向右和向下的方向数组
            int[] dx = {0, 1};
            int[] dy = {1, 0};
            // 是否访问
            boolean[][] vis = new boolean[m][n];
            // 起点入队
            queue.offer(new int[]{0, 0});
            // 起点已经访问
            vis[0][0] = true;
            int ans = 1;
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int i = 0; i < 2; ++i) {
                    // 下一个
                    int tx = dx[i] + x;
                    int ty = dy[i] + y;
                    // 坐标越界 已经访问
                    // 行坐标和列坐标数位之和大于 k 的格子看作障碍物，那么这道题就是一道很传统的搜索题目
                    if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                        continue;
                    }
                    // 入队
                    queue.offer(new int[]{tx, ty});
                    // 标记
                    vis[tx][ty] = true;
                    // 访问格子个数累加
                    ans++;
                }
            }
            return ans;
        }

        private int get(int x) {
            int res = 0;
            while (x != 0) {
                // 123 3+2+1=6
                // 3 32 321
                res += x % 10;
                x /= 10;
            }
            return res;
        }
    }

    /**
     * 起点 起点 起点
     * <p>
     * 入队 标记
     * <p>
     * 入队 标记
     * <p>
     * 起点 起点 起点
     */
    class Solution1 {
        public int movingCount(int m, int n, int k) {
            if (k == 0) {
                return 1;
            }
            // vis[i][j] 为 (i, j) 坐标是否可达
            boolean[][] vis = new boolean[m][n];
            int ans = 1;
            vis[0][0] = true;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                        continue;
                    }
                    // 搜索方向只需朝下或朝右，因此 (i, j) 的格子只会从 (i - 1, j) 或者 (i, j - 1) 两个格子走过来（不考虑边界条件
                    // 边界判断
                    if (i - 1 >= 0) {
                        // 上一行
                        vis[i][j] = vis[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        // 左一个
                        vis[i][j] = vis[i][j] || vis[i][j - 1];
                    }
                    // 如果可达返回 1，否则返回 0
                    ans += vis[i][j] ? 1 : 0;
                }
            }
            return ans;
        }

        private int get(int x) {
            int res = 0;
            while (x != 0) {
                // 123 3+2+1=6
                res += x % 10;
                x /= 10;
            }
            return res;
        }
    }
}
