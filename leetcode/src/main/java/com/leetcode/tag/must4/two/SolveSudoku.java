package com.leetcode.tag.must4.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 37. 解数独
 */
public class SolveSudoku {
    class Solution {
        //行
        private boolean[][] line = new boolean[9][10];
        //列
        private boolean[][] column = new boolean[9][10];
        //小宫格.3*3.3行3列.
        private boolean[][][] block = new boolean[3][3][10];
        private boolean valid = false;
        //保存.的坐标.候选集
        private List<int[]> spaces = new ArrayList<>();

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') {
                        spaces.add(new int[]{i, j});
                    } else {
                        //如果是当前元素是数字,初始化标记数组.和八皇后不一样
                        //digit就是当前坐标的数字.厉害
                        int digit = board[i][j] - '0';
                        line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                    }
                }
            }

            dfs(board, 0);
        }

        /**
         * 只需要在空格填就可以
         * <p>
         * 用 line[2][3]=True 表示数字 4 在第 2 行已经出现过
         * <p>
         * 可以填写的数字范围为 [1, 9]
         *
         * @param board
         * @param pos
         */
        public void dfs(char[][] board, int pos) {
            if (pos == spaces.size()) {
                valid = true;
                return;
            }

            int[] space = spaces.get(pos);
            //行
            int i = space[0];
            //列
            int j = space[1];
            for (int digit = 1; digit <= 9 && !valid; ++digit) {
                if (line[i][digit] || column[j][digit] || block[i / 3][j / 3][digit]) {
                    continue;
                }
                //一行搞定
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                //digit是表示要填的数字
                board[i][j] = (char) (digit + '0');
                dfs(board, pos + 1);
                //一行搞定
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
                //board[i][j]不需要重置.标记数组重置就可以.
            }
        }
    }

    class Solution1 {
        //行
        private boolean[][] line = new boolean[9][10];
        //列
        private boolean[][] column = new boolean[9][10];
        //小宫格.3*3.3行3列.
        private boolean[][][] block = new boolean[3][3][10];
        //保存.的坐标.候选集
        private List<int[]> spaces = new ArrayList<>();

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') {
                        spaces.add(new int[]{i, j});
                    } else {
                        //如果是当前元素是数字,初始化标记数组.和八皇后不一样
                        //digit就是当前坐标的数字.厉害
                        int digit = board[i][j] - '0';
                        line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                    }
                }
            }

            dfs(board, 0);
        }

        /**
         * 只需要在空格填就可以
         * <p>
         * 用 line[2][3]=True 表示数字 4 在第 2 行已经出现过
         * <p>
         * 可以填写的数字范围为 [1, 9]
         *
         * @param board
         * @param pos
         */
        public boolean dfs(char[][] board, int pos) {
            if (pos == spaces.size()) {
                return true;
            }

            int[] space = spaces.get(pos);
            //行
            int i = space[0];
            //列
            int j = space[1];
            for (int digit = 1; digit <= 9; ++digit) {
                if (line[i][digit] || column[j][digit] || block[i / 3][j / 3][digit]) {
                    continue;
                }
                //一行搞定
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                //digit是表示要填的数字
                board[i][j] = (char) (digit + '0');
                if (dfs(board, pos + 1)) {
                    return true;
                }
                //一行搞定
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
                //board[i][j]不需要重置.标记数组重置就可以. board[i][j]本来是 “.” 没有重置就会不断被覆盖
            }

            return false;
        }
    }
}
