package com.leetcode.tag.dfs.one;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 778. 水位上升的泳池中游泳
 * <p>
 * 十分钟看答案.
 */
public class SwimInWater {
    /**
     * 方法一： 堆【通过】
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/swim-in-rising-water/solution/shui-wei-shang-sheng-de-yong-chi-zhong-you-yong-by/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int swimInWater(int[][] grid) {
            int N = grid.length;
            Set<Integer> seen = new HashSet<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(k -> grid[k / N][k % N]));
            pq.offer(0);
            int ans = 0;

            int[] dr = new int[]{1, -1, 0, 0};
            int[] dc = new int[]{0, 0, 1, -1};

            while (!pq.isEmpty()) {
                int k = pq.poll();
                int r = k / N, c = k % N;
                ans = Math.max(ans, grid[r][c]);
                if (r == N - 1 && c == N - 1) {
                    return ans;
                }

                for (int i = 0; i < 4; ++i) {
                    int cr = r + dr[i], cc = c + dc[i];
                    int ck = cr * N + cc;
                    if (0 <= cr && cr < N && 0 <= cc && cc < N && !seen.contains(ck)) {
                        pq.offer(ck);
                        seen.add(ck);
                    }
                }
            }

            return ans;
        }
    }
}
