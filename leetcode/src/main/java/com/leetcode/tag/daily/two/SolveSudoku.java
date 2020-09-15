package com.leetcode.tag.daily.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 37. 解数独
 * <p>
 * 十分钟看答案
 * <p>
 * 十分钟看答案
 * <p>
 * 十分钟看答案
 */
public class SolveSudoku {
    /**
     * 检查行、列、3*3宫格
     */
    class Solution {
        public void solveSudoku(char[][] board) {

        }
    }

    /**
     * 方法一：递归
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sudoku-solver/solution/jie-shu-du-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        //行
        private boolean[][] line = new boolean[9][9];
        //列
        private boolean[][] column = new boolean[9][9];
        //小宫格.3*3.3行3列.
        private boolean[][][] block = new boolean[3][3][9];
        private boolean valid = false;
        //保存.的坐标
        private List<int[]> spaces = new ArrayList<>();

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') {
                        spaces.add(new int[]{i, j});
                    } else {
                        //如果是当前元素是数字,初始化标记数组.和八皇后不一样
                        //digit就是当前坐标的数字.厉害
                        int digit = board[i][j] - '0' - 1;
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
            for (int digit = 0; digit < 9 && !valid; ++digit) {
                if (line[i][digit] || column[j][digit] || block[i / 3][j / 3][digit]) {
                    continue;
                }
                //一行搞定
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                //digit是下标,digit+1才表示要填的数字
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                //一行搞定
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
                //board[i][j]不需要重置.标记数组重置就可以.
            }
        }
    }

    /**
     * 方法二：位运算优化
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sudoku-solver/solution/jie-shu-du-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        private int[] line = new int[9];
        private int[] column = new int[9];
        private int[][] block = new int[3][3];
        private boolean valid = false;
        private List<int[]> spaces = new ArrayList<>();

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') {
                        spaces.add(new int[]{i, j});
                    } else {
                        int digit = board[i][j] - '0' - 1;
                        flip(i, j, digit);
                    }
                }
            }

            dfs(board, 0);
        }

        public void dfs(char[][] board, int pos) {
            if (pos == spaces.size()) {
                valid = true;
                return;
            }

            int[] space = spaces.get(pos);
            int i = space[0], j = space[1];
            int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
            for (; mask != 0 && !valid; mask &= (mask - 1)) {
                int digitMask = mask & (-mask);
                int digit = Integer.bitCount(digitMask - 1);
                flip(i, j, digit);
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                flip(i, j, digit);
            }
        }

        public void flip(int i, int j, int digit) {
            line[i] ^= (1 << digit);
            column[j] ^= (1 << digit);
            block[i / 3][j / 3] ^= (1 << digit);
        }
    }

}
