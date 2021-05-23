package com.leetcode.tag.must4.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * 37. 解数独
 */
public class SolveSudoku {
    class Solution {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][][] min = new boolean[3][3][10];
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
            int[] ints = list.get(index);
            int i = ints[0];
            int j = ints[1];

            for (int k = 1; k <= 9; k++) {
                if (row[i][k] || col[j][k] || min[i / 3][j / 3][k]) {
                    continue;
                }
                row[i][k] = col[j][k] = min[i / 3][j / 3][k] = true;
                board[i][j] = (char) (k + '0');

                if (dfs(board, index + 1)) {
                    return true;
                }

                row[i][k] = col[j][k] = min[i / 3][j / 3][k] = false;
            }

            return false;
        }
    }
}
