package com.leetcode.tag.must1.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 */
public class SolveNQueens {
    class Solution {
        boolean[] col;
        boolean[] left;
        boolean[] right;
        char[][] chars;
        List<List<String>> result;

        public List<List<String>> solveNQueens(int n) {
            col = new boolean[n];
            left = new boolean[2 * n];
            right = new boolean[2 * n];
            chars = new char[n][n];
            result = new ArrayList<>();

            for (char[] aChar : chars) {
                Arrays.fill(aChar, '.');
            }

            dfs(n, 0);

            return result;
        }

        private void dfs(int n, int i) {
            if (i == n) {
                List<String> list = new ArrayList<>();
                for (char[] aChar : chars) {
                    list.add(Arrays.toString(aChar));
                }
                result.add(list);
                return;
            }
            for (int k = 0; k < n; k++) {
                if (col[k] || left[i + k] || right[n - i + k]) {
                    continue;
                }
                col[k] = true;
                left[i + k] = true;
                right[n - i + k] = true;
                chars[i][k] = 'Q';

                dfs(n, i + 1);

                col[k] = false;
                left[i + k] = false;
                right[n - i + k] = false;
                chars[i][k] = '.';
            }
        }

    }
}
