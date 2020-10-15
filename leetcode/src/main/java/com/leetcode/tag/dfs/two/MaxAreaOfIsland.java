package com.leetcode.tag.dfs.two;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 695. 岛屿的最大面积
 * <p>
 * 难点:矩阵缓存
 */
public class MaxAreaOfIsland {
    class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        boolean[][] visited;

        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            visited = new boolean[grid.length][grid[0].length];
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (visited[i][j] || grid[i][j] == 0) {
                        continue;
                    }
                    max = Math.max(max, dfs(grid, i, j));
                }
            }

            return max;
        }

        private int dfs(int[][] grid, int row, int col) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
                return 0;
            }
            visited[row][col] = true;
            int result = 1;
            for (int i = 0; i < rows.length; i++) {
                result += dfs(grid, row + rows[i], col + cols[i]);
            }

            return result;
        }
    }

    /**
     * 方法一：深度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/max-area-of-island/solution/dao-yu-de-zui-da-mian-ji-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int maxAreaOfIsland(int[][] grid) {
            int ans = 0;
            for (int i = 0; i != grid.length; ++i) {
                for (int j = 0; j != grid[0].length; ++j) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
            return ans;
        }

        public int dfs(int[][] grid, int curI, int curJ) {
            if (curI < 0 || curJ < 0 || curI == grid.length || curJ == grid[0].length || grid[curI][curJ] != 1) {
                return 0;
            }
            //修改矩阵.作用类似visited.
            grid[curI][curJ] = 0;
            int[] di = {0, 0, 1, -1};
            int[] dj = {1, -1, 0, 0};
            int ans = 1;
            for (int index = 0; index != 4; ++index) {
                int nextI = curI + di[index], nextJ = curJ + dj[index];
                ans += dfs(grid, nextI, nextJ);
            }
            return ans;
        }
    }

    /**
     * 方法二：深度优先搜索 + 栈
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/max-area-of-island/solution/dao-yu-de-zui-da-mian-ji-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int maxAreaOfIsland(int[][] grid) {
            int ans = 0;
            for (int i = 0; i != grid.length; ++i) {
                for (int j = 0; j != grid[0].length; ++j) {
                    int cur = 0;
                    //放row
                    Deque<Integer> stackI = new LinkedList<>();
                    //放col
                    Deque<Integer> stackJ = new LinkedList<>();
                    stackI.push(i);
                    stackJ.push(j);
                    while (!stackI.isEmpty()) {
                        int curI = stackI.pop(), curJ = stackJ.pop();
                        if (curI < 0 || curJ < 0 || curI == grid.length || curJ == grid[0].length || grid[curI][curJ] != 1) {
                            continue;
                        }
                        ++cur;
                        grid[curI][curJ] = 0;
                        //访问每一片土地时，我们将对围绕它四个方向进行探索，找到还未访问的土地，加入到栈 stack 中；
                        int[] di = {0, 0, 1, -1};
                        int[] dj = {1, -1, 0, 0};
                        for (int index = 0; index != 4; ++index) {
                            int nextI = curI + di[index], nextJ = curJ + dj[index];
                            stackI.push(nextI);
                            stackJ.push(nextJ);
                        }
                    }
                    ans = Math.max(ans, cur);
                }
            }
            return ans;
        }
    }

}
