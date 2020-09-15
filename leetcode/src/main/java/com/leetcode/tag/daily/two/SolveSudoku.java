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
        //小宫格
        private boolean[][][] block = new boolean[3][3][9];
        private boolean valid = false;
        private List<int[]> spaces = new ArrayList<>();

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') {
                        spaces.add(new int[]{i, j});
                    } else {
                        int digit = board[i][j] - '0' - 1;
                        line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
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
            for (int digit = 0; digit < 9 && !valid; ++digit) {
                if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                    //一行搞定
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                    board[i][j] = (char) (digit + '0' + 1);
                    dfs(board, pos + 1);
                    //一行搞定
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
                }
            }
        }
    }

}
