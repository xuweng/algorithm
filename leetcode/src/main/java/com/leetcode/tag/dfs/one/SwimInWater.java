package com.leetcode.tag.dfs.one;

import java.util.*;

/**
 * 778. 水位上升的泳池中游泳
 * <p>
 * 十分钟看答案.
 * <p>
 * Dijkstra算法
 * <p>
 * Dijkstra(迪杰斯特拉)算法是典型的单源最短路径算法
 * <p>
 * 无向图
 * <p>
 * 带权有向图
 * <p>
 * Floyd-Warshall算法（Floyd-Warshall algorithm）是解决任意两点间的最短路径的一种算法
 * <p>
 * Floyd算法是一个经典的动态规划算法
 */
public class SwimInWater {
    /**
     * 方法一： 堆【通过】
     * <p>
     * 用优先队列保存下一步可以游向的平台，每次都选择高度最小的平台。以这种方式到达终点时，路径中遇到的最高平台就是答案。
     * <p>
     * 所有的能走的点中我们永远只走水位最低的点，每到一个点，我们再记录所有的周围能走的点，并再次选择所有能走的点中水位最低的点
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/swim-in-rising-water/solution/shui-wei-shang-sheng-de-yong-chi-zhong-you-yong-by/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int swimInWater(int[][] grid) {
            int N = grid.length;
            Set<Integer> visited = new HashSet<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(k -> grid[k / N][k % N]));
            priorityQueue.offer(0);
            int ans = 0;

            //上下左右4个方向
            //其实是右下2个方向
            int[] row = new int[]{1, -1, 0, 0};
            int[] col = new int[]{0, 0, 1, -1};

            while (!priorityQueue.isEmpty()) {
                int k = priorityQueue.poll();
                //计算行
                int r = k / N;
                //计算列
                int c = k % N;
                ans = Math.max(ans, grid[r][c]);
                if (r == N - 1 && c == N - 1) {
                    return ans;
                }

                //遍历上下左右
                for (int i = 0; i < 4; ++i) {
                    int cr = r + row[i];
                    int cc = c + col[i];
                    int ck = cr * N + cc;
                    if (0 <= cr && cr < N && 0 <= cc && cc < N && !visited.contains(ck)) {
                        priorityQueue.offer(ck);
                        visited.add(ck);
                    }
                }
            }

            return ans;
        }
    }

    /**
     * 方法二： 二分搜索 + 深度优先搜索
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/swim-in-rising-water/solution/shui-wei-shang-sheng-de-yong-chi-zhong-you-yong-by/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int swimInWater(int[][] grid) {
            int N = grid.length;
            int low = grid[0][0], high = N * N;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (!possible(mid, grid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        public boolean possible(int T, int[][] grid) {
            int N = grid.length;
            Set<Integer> seen = new HashSet<>();
            seen.add(0);
            int[] dr = new int[]{1, -1, 0, 0};
            int[] dc = new int[]{0, 0, 1, -1};

            Stack<Integer> stack = new Stack<>();
            stack.add(0);

            while (!stack.empty()) {
                int k = stack.pop();
                int r = k / N, c = k % N;
                if (r == N - 1 && c == N - 1) {
                    return true;
                }

                for (int i = 0; i < 4; ++i) {
                    int cr = r + dr[i], cc = c + dc[i];
                    int ck = cr * N + cc;
                    if (0 <= cr && cr < N && 0 <= cc && cc < N
                            && !seen.contains(ck) && grid[cr][cc] <= T) {
                        stack.add(ck);
                        seen.add(ck);
                    }
                }
            }

            return false;
        }
    }

}
