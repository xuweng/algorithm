package com.leetcode.tag.tree.two;

/**
 * 79. 单词搜索
 */
public class WordSearch {
    class Solution {
        //上下左右
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};

        public boolean exist(char[][] board, String word) {
            if (word == null || word.isEmpty()) {
                return false;
            }
            boolean[][] used = new boolean[board.length][board[0].length];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0) && (word.length() == 1 || back(board, word, 0, i, j, used))) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean back(char[][] board, String word, int begin, int row, int col, boolean[][] used) {
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
                return false;
            }
            if (begin >= word.length()) {
                return true;
            }
            if (board[row][col] != word.charAt(begin)) {
                return false;
            }
            for (int i = 0; i < 4; i++) {
                if (used[row][col]) {
                    continue;
                }
                used[row][col] = true;
                if (back(board, word, begin + 1, row + rows[i], col + cols[i], used)) {
                    return true;
                }
                used[row][col] = false;

            }

            return false;
        }
    }
}
