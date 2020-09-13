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

    /**
     * 方法一：深度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/word-search/solution/dan-ci-sou-suo-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean exist(char[][] board, String word) {
            int h = board.length, w = board[0].length;
            boolean[][] visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    boolean flag = check(board, visited, i, j, word, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
            if (board[i][j] != s.charAt(k)) {
                return false;
            } else if (k == s.length() - 1) {
                return true;
            }
            visited[i][j] = true;
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            boolean result = false;
            for (int[] dir : directions) {
                int newi = i + dir[0], newj = j + dir[1];
                if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                    if (!visited[newi][newj]) {
                        boolean flag = check(board, visited, newi, newj, s, k + 1);
                        if (flag) {
                            result = true;
                            break;
                        }
                    }
                }
            }
            visited[i][j] = false;
            return result;
        }
    }

}
