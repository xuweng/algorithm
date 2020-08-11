package com.leetcode.tag.daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 130. 被围绕的区域
 * <p>
 * 这道题我们拿到基本就可以确定是图的 dfs、bfs 遍历的题目了
 * <p>
 * 问题转化为，如何寻找和边界联通的 O
 * <p>
 * 学不到什么东西。学不到什么东西。学不到什么东西。
 * <p>
 * 真的是十分钟没有思路看题解。
 * <p>
 * 十分钟。十分钟。十分钟。十分钟。十分钟。十分钟。十分钟
 */
public class SurroundedRegions {
    class Solution {
        /**
         * 所有的不被包围的 O 都直接或间接与边界上的 O 相连
         * <p>
         * 对于每一个边界上的 O，我们以它为起点，标记所有与它直接或间接相连的字母 O
         * <p>
         * 对于每一个边界上的 O，我们以它为起点，标记所有与它直接或间接相连的字母 O；
         * <p>
         * 最后我们遍历这个矩阵，对于每一个字母：
         * <p>
         * 如果该字母被标记过，则该字母为没有被字母 X 包围的字母 O，我们将其还原为字母 O；
         * <p>
         * 如果该字母没有被标记过，则该字母为被字母 X 包围的字母 O，我们将其修改为字母 X。
         *
         * @param board
         */
        public void solve(char[][] board) {

        }
    }

    /**
     * 方法一：深度优先搜索
     * <p>
     * 时间复杂度：O(n×m).深度优先搜索过程中，每一个点至多只会被标记一次
     * <p>
     * 空间复杂度：O(n×m)
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/surrounded-regions/solution/bei-wei-rao-de-qu-yu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int n, m;

        /**
         * 4条边界
         *
         * @param board
         */
        public void solve(char[][] board) {
            n = board.length;
            if (n == 0) {
                return;
            }
            m = board[0].length;
            for (int i = 0; i < n; i++) {
                //左边界
                dfs(board, i, 0);
                //右边界
                dfs(board, i, m - 1);
            }
            for (int i = 1; i < m - 1; i++) {
                //上边界
                dfs(board, 0, i);
                //下边界
                dfs(board, n - 1, i);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'A') {
                        //已经标记
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        //没有标记
                        board[i][j] = 'X';
                    }
                }
            }
        }

        public void dfs(char[][] board, int x, int y) {
            if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
                return;
            }
            //标记
            board[x][y] = 'A';
            dfs(board, x + 1, y);
            dfs(board, x - 1, y);
            dfs(board, x, y + 1);
            dfs(board, x, y - 1);
        }
    }

    /**
     * 方法二：广度优先搜索
     * <p>
     * 时间复杂度：O(n×m)。广度优先搜索过程中，每一个点至多只会被标记一次。
     * <p>
     * 空间复杂度：O(n×m)。主要为广度优先搜索的队列的开销。
     */
    class Solution3 {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        public void solve(char[][] board) {
            int n = board.length;
            if (n == 0) {
                return;
            }
            int m = board[0].length;
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (board[i][0] == 'O') {
                    queue.offer(new int[]{i, 0});
                }
                if (board[i][m - 1] == 'O') {
                    queue.offer(new int[]{i, m - 1});
                }
            }
            for (int i = 1; i < m - 1; i++) {
                if (board[0][i] == 'O') {
                    queue.offer(new int[]{0, i});
                }
                if (board[n - 1][i] == 'O') {
                    queue.offer(new int[]{n - 1, i});
                }
            }
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                board[x][y] = 'A';
                for (int i = 0; i < 4; i++) {
                    int mx = x + dx[i], my = y + dy[i];
                    if (mx < 0 || my < 0 || mx >= n || my >= m || board[mx][my] != 'O') {
                        continue;
                    }
                    queue.offer(new int[]{mx, my});
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'A') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

}
