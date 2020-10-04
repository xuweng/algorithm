package com.leetcode.tag.dfs.one;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 778. 水位上升的泳池中游泳
 * <p>
 * 十分钟看答案.
 * <p>
 * Dijkstra算法
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
}
