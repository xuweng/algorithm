package com.leetcode.tag.daily;

/**
 * 529. 扫雷游戏
 */
public class UpdateBoard {
    class Solution {
        public char[][] updateBoard(char[][] board, int[] click) {
            return null;
        }
    }

    /**
     * 方法一：深度优先搜索 + 模拟
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/minesweeper/solution/sao-lei-you-xi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

        public char[][] updateBoard(char[][] board, int[] click) {
            int x = click[0], y = click[1];
            if (board[x][y] == 'M') {
                // 规则 1
                board[x][y] = 'X';
            } else {
                dfs(board, x, y);
            }
            return board;
        }

        public void dfs(char[][] board, int x, int y) {
            int cnt = 0;
            for (int i = 0; i < 8; ++i) {
                int tx = x + dirX[i];
                int ty = y + dirY[i];
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                    continue;
                }
                // 不用判断 M，因为如果有 M 的话游戏已经结束了
                if (board[tx][ty] == 'M') {
                    ++cnt;
                }
            }
            if (cnt > 0) {
                // 规则 3
                board[x][y] = (char) (cnt + '0');
            } else {
                // 规则 2
                board[x][y] = 'B';
                for (int i = 0; i < 8; ++i) {
                    int tx = x + dirX[i];
                    int ty = y + dirY[i];
                    // 这里不需要在存在 B 的时候继续扩展，因为 B 之前被点击的时候已经被扩展过了
                    if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E') {
                        continue;
                    }
                    dfs(board, tx, ty);
                }
            }
        }
    }

}
