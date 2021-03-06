package com.leetcode.tag.dfs.one;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 */
public class UpdateMatrix {
    static class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        boolean[][] used;
        int result = Integer.MAX_VALUE;

        public int[][] updateMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new int[0][0];
            }
            used = new boolean[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int i1 = 0; i1 < matrix[0].length; i1++) {
                    if (matrix[i][i1] == 1) {
                        dfs(matrix, i, i1, 0);
                        matrix[i][i1] = result;
                        result = Integer.MAX_VALUE;
                    }
                }
            }
            return matrix;
        }

        private void dfs(int[][] matrix, int row, int col, int count) {
            if (count > result) {
                return;
            }
            if (matrix[row][col] == 0) {
                result = count;
                return;
            }
            used[row][col] = true;
            for (int i = 0; i < rows.length; i++) {
                int r = row + rows[i];
                int c = col + cols[i];
                if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || used[r][c]) {
                    continue;
                }
                dfs(matrix, r, c, count + 1);
            }
            used[row][col] = false;
        }
    }

    /**
     * 方法一：广度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/01-matrix/solution/01ju-zhen-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int[][] updateMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] dist = new int[m][n];
            boolean[][] seen = new boolean[m][n];
            //保存坐标
            Queue<int[]> queue = new LinkedList<>();
            // 将所有的 0 添加进初始队列中
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                        seen[i][j] = true;
                    }
                }
            }

            // 广度优先搜索
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int i = cell[0], j = cell[1];
                //上下左右
                for (int d = 0; d < 4; ++d) {
                    int ni = i + dirs[d][0];
                    int nj = j + dirs[d][1];
                    //边界检查、是否访问
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                        //计算
                        dist[ni][nj] = dist[i][j] + 1;
                        queue.offer(new int[]{ni, nj});
                        seen[ni][nj] = true;
                    }
                }
            }

            return dist;
        }
    }

    /**
     * 方法二：动态规划
     * <p>
     * 4个移动方向的dp
     * <p>
     * 画图.看图.
     * <p>
     * 用 f(i,j) 表示位置 (i,j) 到最近的 0 的距离
     * <p>
     * 状态转移方程:
     * f(i,j) = 1+min(f(i−1,j),f(i,j−1)) 位置 (i,j) 的元素为 1
     * f(i,j) = 0                        位置 (i,j) 的元素为 0
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/01-matrix/solution/01ju-zhen-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int[][] updateMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            // 初始化动态规划的数组，所有的距离值都设置为一个很大的数
            int[][] dist = new int[m][n];
            for (int i = 0; i < m; ++i) {
                Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
            }
            // 如果 (i, j) 的元素为 0，那么距离为 0
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][j] == 0) {
                        dist[i][j] = 0;
                    }
                }
            }
            // 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    //注意数组越界
                    if (i - 1 >= 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                    }
                }
            }
            // 只有 水平向左移动 和 竖直向下移动，注意动态规划的计算顺序
            for (int i = m - 1; i >= 0; --i) {
                for (int j = 0; j < n; ++j) {
                    if (i + 1 < m) {
                        dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                    }
                }
            }
            // 只有 水平向右移动 和 竖直向上移动，注意动态规划的计算顺序
            for (int i = 0; i < m; ++i) {
                for (int j = n - 1; j >= 0; --j) {
                    if (i - 1 >= 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    }
                    if (j + 1 < n) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                    }
                }
            }
            // 只有 水平向右移动 和 竖直向下移动，注意动态规划的计算顺序
            for (int i = m - 1; i >= 0; --i) {
                for (int j = n - 1; j >= 0; --j) {
                    if (i + 1 < m) {
                        dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                    }
                    if (j + 1 < n) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                    }
                }
            }
            return dist;
        }
    }

    /**
     * 矩阵的移动方向
     * <p>
     * 方法三：动态规划的常数优化
     * <p>
     * 只有 水平向左移动 和 竖直向上移动；
     * <p>
     * 只有 水平向右移动 和 竖直向下移动。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/01-matrix/solution/01ju-zhen-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int[][] updateMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            // 设置大值
            // 初始化动态规划的数组，所有的距离值都设置为一个很大的数
            int[][] dist = new int[m][n];
            for (int i = 0; i < m; ++i) {
                Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
            }
            // 如果 (i, j) 的元素为 0，那么距离为 0
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][j] == 0) {
                        dist[i][j] = 0;
                    }
                }
            }
            // 行-1或者列-1
            // 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (i - 1 >= 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                    }
                }
            }
            // 行+1或者列+1
            // 只有 水平向右移动 和 竖直向下移动，注意动态规划的计算顺序
            for (int i = m - 1; i >= 0; --i) {
                for (int j = n - 1; j >= 0; --j) {
                    if (i + 1 < m) {
                        dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                    }
                    if (j + 1 < n) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                    }
                }
            }
            return dist;
        }
    }

}
