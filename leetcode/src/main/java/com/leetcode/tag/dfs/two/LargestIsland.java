package com.leetcode.tag.dfs.two;

import java.util.*;

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
            // 是否有0
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
            // 保存每个访问的结点
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

    /**
     * 方法 2：连通块大小【通过】
     * <p>
     * 记录连通块编号
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/making-a-large-island/solution/zui-da-ren-gong-dao-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};
        int[][] grid;
        int N;

        public int largestIsland(int[][] grid) {
            this.grid = grid;
            N = grid.length;

            int index = 2;
            int[] area = new int[N * N + 2];
            for (int r = 0; r < N; ++r) {
                for (int c = 0; c < N; ++c) {
                    if (grid[r][c] == 1) {
                        area[index] = dfs(r, c, index++);
                    }
                }
            }

            int ans = 0;
            for (int x : area) {
                ans = Math.max(ans, x);
            }
            for (int r = 0; r < N; ++r) {
                for (int c = 0; c < N; ++c) {
                    // 处理为0
                    if (grid[r][c] == 0) {
                        Set<Integer> seen = new HashSet<>();
                        // 4个连通块累加
                        for (Integer move : neighbors(r, c)) {
                            if (grid[move / N][move % N] > 1) {
                                seen.add(grid[move / N][move % N]);
                            }
                        }

                        int bns = 1 + seen.stream().mapToInt(i -> i).map(i -> area[i]).sum();
                        ans = Math.max(ans, bns);
                    }
                }
            }

            return ans;
        }

        /**
         * @param r
         * @param c
         * @param index 连通块编号
         * @return
         */
        public int dfs(int r, int c, int index) {
            int ans = 1;
            grid[r][c] = index;
            for (Integer move : neighbors(r, c)) {
                if (grid[move / N][move % N] == 1) {
                    // 邻接顶点编号为index
                    grid[move / N][move % N] = index;
                    ans += dfs(move / N, move % N, index);
                }
            }

            return ans;
        }

        /**
         * 获取邻接顶点
         *
         * @param r
         * @param c
         * @return
         */
        public List<Integer> neighbors(int r, int c) {
            List<Integer> ans = new ArrayList<>();
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 > nr || nr >= N || 0 > nc || nc >= N) {
                    continue;
                }
                ans.add(nr * N + nc);
            }

            return ans;
        }
    }

    /**
     * 作者：caipengbo
     * 链接：https://leetcode-cn.com/problems/making-a-large-island/solution/jian-dan-yi-yu-li-jie-de-java-dfsfang-fa-by-caipen/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        private int curIslandArea;

        public int largestIsland(int[][] grid) {
            // 1 <= grid.length = grid[0].length <= 50
            int m = grid.length, n = grid[0].length;
            int[] area = new int[250];
            int index = 2, maxIslandArea = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    curIslandArea = 0;
                    dfs(grid, i, j, index);
                    if (curIslandArea != 0) {
                        // 岛屿的最大面积
                        maxIslandArea = Math.max(maxIslandArea, curIslandArea);
                        // 记录每一块岛屿的面积
                        area[index++] = curIslandArea;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        maxIslandArea = Math.max(maxIslandArea, changeSea(grid, m, n, area, i, j));
                    }
                }
            }
            return maxIslandArea;
        }

        // DFS 求每一个小岛，并且获得每一个小岛的面积
        private void dfs(int[][] grid, int i, int j, int index) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
                return;
            }
            grid[i][j] = index;
            curIslandArea++;
            // 在此处判断，不用进入下一层递归
            dfs(grid, i - 1, j, index);
            dfs(grid, i + 1, j, index);
            dfs(grid, i, j - 1, index);
            dfs(grid, i, j + 1, index);
        }

        // 尝试改变每一个海洋(为0的地方)
        private int changeSea(int[][] grid, int m, int n, int[] area, int i, int j) {
            Set<Integer> set = new HashSet<>();
            int areaSum = 1;
            if (i - 1 >= 0) {
                set.add(grid[i - 1][j]);
            }
            if (i + 1 < m) {
                set.add(grid[i + 1][j]);
            }
            if (j - 1 >= 0) {
                set.add(grid[i][j - 1]);
            }
            if (j + 1 < n) {
                set.add(grid[i][j + 1]);
            }
            for (Integer index : set) {
                areaSum += area[index];
            }
            return areaSum;
        }
    }

}
