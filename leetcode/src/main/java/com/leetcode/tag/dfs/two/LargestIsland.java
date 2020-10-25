package com.leetcode.tag.dfs.two;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 827. 最大人工岛
 * <p>
 * 十分钟.十分钟.十分钟.十分钟.
 * <p>
 * 总结归纳.总结归纳.总结归纳.总结归纳.
 */
public class LargestIsland {
    /**
     * 方法 1：深度优先搜索【超时】
     * <p>
     * 对于每个 0，将它变成 1，然后做一次深度优先搜索计算出连通块的大小。答案就是找到的最大连通块。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/making-a-large-island/solution/zui-da-ren-gong-dao-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};

        public int largestIsland(int[][] grid) {
            int N = grid.length;

            int ans = 0;
            boolean hasZero = false;
            for (int r = 0; r < N; ++r) {
                for (int c = 0; c < N; ++c) {
                    if (grid[r][c] == 0) {
                        hasZero = true;
                        grid[r][c] = 1;
                        ans = Math.max(ans, check(grid, r, c));
                        grid[r][c] = 0;
                    }
                }
            }

            return hasZero ? ans : N * N;
        }

        /**
         * 用栈dfs
         *
         * @param grid
         * @param r0
         * @param c0
         * @return
         */
        public int check(int[][] grid, int r0, int c0) {
            int N = grid.length;
            Stack<Integer> stack = new Stack<>();
            Set<Integer> seen = new HashSet<>();
            // 保证每个点都不一样
            stack.push(r0 * N + c0);
            seen.add(r0 * N + c0);

            while (!stack.isEmpty()) {
                int code = stack.pop();
                int r = code / N, c = code % N;
                for (int k = 0; k < 4; ++k) {
                    int nr = r + dr[k], nc = c + dc[k];
                    // 是否访问和越界
                    if (seen.contains(nr * N + nc) || 0 > nr || nr >= N ||
                            0 > nc || nc >= N || grid[nr][nc] != 1) {
                        continue;
                    }
                    stack.push(nr * N + nc);
                    seen.add(nr * N + nc);
                }
            }

            return seen.size();
        }
    }
}
