package com.leetcode.tag.dfs.one;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 329. 矩阵中的最长递增路径
 */
public class LongestIncreasingPath {
    class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        boolean[][] visited;
        int count;
        int result;

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            visited = new boolean[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    dfs(matrix, i, j, 1);
                    result = Math.max(result, count);
                    count = 0;
                }
            }

            return result;
        }

        private void dfs(int[][] matrix, int row, int col, int count) {
            this.count = Math.max(this.count, count);
            visited[row][col] = true;
            for (int i = 0; i < rows.length; i++) {
                int r = row + rows[i];
                int c = col + cols[i];
                if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || visited[r][c] || matrix[r][c] <= matrix[row][col]) {
                    continue;
                }
                dfs(matrix, r, c, count + 1);
            }
            visited[row][col] = false;
        }
    }

    /**
     * 方法一：记忆化深度优先搜索
     * <p>
     * 大量的重复计算，同一个单元格会被访问多次，每次访问都要重新计算。
     * <p>
     * 由于同一个单元格对应的最长递增路径的长度是固定不变的，因此可以使用记忆化的方法进行优化。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/solution/ju-zhen-zhong-de-zui-chang-di-zeng-lu-jing-by-le-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int rows, columns;
        //矩阵缓存
        int[][] memo;

        public int longestIncreasingPath(int[][] matrix) {
            //校验
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            rows = matrix.length;
            columns = matrix[0].length;
            memo = new int[rows][columns];
            int ans = 0;
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    if (memo[i][j] != 0) {
                        continue;
                    }
                    ans = Math.max(ans, dfs(matrix, i, j));
                }
            }
            return ans;
        }

        /**
         * 定义函数为求坐标的最长递增路径
         *
         * @param matrix
         * @param row
         * @param column
         * @return
         */
        public int dfs(int[][] matrix, int row, int column) {
            if (memo[row][column] != 0) {
                return memo[row][column];
            }
            //初始化为1
            ++memo[row][column];
            for (int[] dir : dirs) {
                int newRow = row + dir[0], newColumn = column + dir[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                    memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn) + 1);
                }
            }
            return memo[row][column];
        }
    }

    /**
     * 方法二：拓扑排序
     * <p>
     * 每个单元格对应的最长递增路径的结果只和相邻单元格的结果有关
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/solution/ju-zhen-zhong-de-zui-chang-di-zeng-lu-jing-by-le-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int rows, columns;

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            rows = matrix.length;
            columns = matrix[0].length;
            int[][] outdegrees = new int[rows][columns];
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    for (int[] dir : dirs) {
                        int newRow = i + dir[0], newColumn = j + dir[1];
                        if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[i][j]) {
                            ++outdegrees[i][j];
                        }
                    }
                }
            }
            Queue<int[]> queue = new LinkedList<int[]>();
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    if (outdegrees[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                    }
                }
            }
            int ans = 0;
            while (!queue.isEmpty()) {
                ++ans;
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    int[] cell = queue.poll();
                    int row = cell[0], column = cell[1];
                    for (int[] dir : dirs) {
                        int newRow = row + dir[0], newColumn = column + dir[1];
                        if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] < matrix[row][column]) {
                            --outdegrees[newRow][newColumn];
                            if (outdegrees[newRow][newColumn] == 0) {
                                queue.offer(new int[]{newRow, newColumn});
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }

    class Solution3 {
        //搜索题解：java实现 深度优先 超级简单易懂
        //dfs+动态规划：时间：O(m * n)
        //思路：先从一个格子开始找，对比它4周的格子，有没有比它小的，如果有，比如有A，B，C三个格子都比它小，那么当前格子的最大连续递增长度就是这3个格子的最大连续递增长度中的最大值+1
        public int longestIncreasingPath(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            int m = matrix.length, n = matrix[0].length;
            int max = 0;
            //记录当前格子的最长递增路径以及是否访问过，已经访问过的记录最长路径
            int[][] visited = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //该位置没有访问过才dfs搜索
                    if (visited[i][j] == 0) {
                        max = Math.max(max, dfs(matrix, i, j, visited));
                    }
                }
            }
            return max;
        }

        //以[i,j]位置开始向上下左右搜索最长递增路径，返回最长路径
        private int dfs(int[][] matrix, int i, int j, int[][] visited) {
            if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
                return 0;
            }
            //避免重复计算，如果之前已经算过了最长路径了，直接返回
            if (visited[i][j] > 0) {
                return visited[i][j];
            }
            int max = 0;
            int cur = matrix[i][j];
            //上下左右递归找是否比当前数字小，找到最长递增路径
            if (i > 0 && matrix[i - 1][j] < cur) {
                max = Math.max(max, dfs(matrix, i - 1, j, visited));
            }
            if (i < matrix.length - 1 && matrix[i + 1][j] < cur) {
                max = Math.max(max, dfs(matrix, i + 1, j, visited));
            }
            if (j > 0 && matrix[i][j - 1] < cur) {
                max = Math.max(max, dfs(matrix, i, j - 1, visited));
            }
            if (j < matrix[0].length - 1 && matrix[i][j + 1] < cur) {
                max = Math.max(max, dfs(matrix, i, j + 1, visited));
            }
            //更新[i,j]位置最长递增路径+1
            visited[i][j] = max + 1;
            return visited[i][j];
        }
    }


}
