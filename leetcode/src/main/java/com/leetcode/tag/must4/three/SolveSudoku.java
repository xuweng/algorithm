package com.leetcode.tag.must4.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 37. 解数独
 */
public class SolveSudoku {
    class Solution {
        // 9行9个数
        boolean[][] row = new boolean[9][10];
        // 9列9个数
        boolean[][] col = new boolean[9][10];
        // 3*3矩阵
        boolean[][][] min = new boolean[3][3][10];
        // 候选集
        List<int[]> list = new ArrayList<>();

        public void solveSudoku(char[][] board) {
            int m = board.length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == '.') {
                        list.add(new int[]{i, j});
                    } else {
                        int v = board[i][j] - '0';
                        row[i][v] = col[j][v] = min[i / 3][j / 3][v] = true;
                    }
                }
            }

            dfs(board, 0);
        }

        private boolean dfs(char[][] board, int index) {
            if (index == list.size()) {
                return true;
            }
            int[] a = list.get(index);
            int r = a[0];
            int c = a[1];
            for (int i = 1; i <= 9; i++) {
                if (row[r][i] || col[c][i] || min[r / 3][c / 3][i]) {
                    continue;
                }
                row[r][i] = col[c][i] = min[r / 3][c / 3][i] = true;
                board[r][c] = (char) (i + '0');

                if (dfs(board, index + 1)) {
                    return true;
                }

                //  board[r][c]不需要重置
                row[r][i] = col[c][i] = min[r / 3][c / 3][i] = false;
            }

            return false;
        }
    }
}
