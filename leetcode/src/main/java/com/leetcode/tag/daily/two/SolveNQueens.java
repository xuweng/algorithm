package com.leetcode.tag.daily.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 51. N 皇后
 * <p>
 * 成熟的算法
 */
public class SolveNQueens {
    class Solution {
        // 标记列。容易标记。
        private boolean[] col;
        // 标记左对角线。对角线怎么标记
        private boolean[] left;
        // 标记右对角线。标记对角线。
        private boolean[] right;

        private List<List<String>> ret = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            col = new boolean[n];
            left = new boolean[2 * n - 1];
            right = new boolean[2 * n - 1];
            char[][] board = new char[n][n];
            backTrack(board, 0, n);
            return ret;
        }

        /**
         * 回溯算法模板
         *
         * @param board
         * @param row
         * @param n
         */
        private void backTrack(char[][] board, int row, int n) {
            //越界统计
            if (row >= n) {
                List<String> list = IntStream.range(0, n).mapToObj(i -> String.valueOf(board[i])).collect(Collectors.toList());
                ret.add(list);
                return;
            }
            //初始化row行
            Arrays.fill(board[row], '.');
            for (int i = 0; i < n; i++) {
                //左对角线和右对角线是难点
                // 第i列是否填。左对角线是否填。右对角线是否填。
                if (col[i] || left[row + i] || right[row - i + n - 1]) {
                    continue;
                }
                // 标记第i列已填
                col[i] = true;
                // 通过坐标计算左右对角线
                // 标记左对角线已填。行+列=左对角线。厉害。
                left[row + i] = true;
                right[row - i + n - 1] = true;
                //填第row行。选择第i列。
                board[row][i] = 'Q';
                //填下一行
                backTrack(board, row + 1, n);
                //回溯
                col[i] = false;
                board[row][i] = '.';
                left[row + i] = false;
                right[row - i + n - 1] = false;
            }
        }
    }
}
