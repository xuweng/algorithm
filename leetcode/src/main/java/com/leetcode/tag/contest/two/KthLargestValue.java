package com.leetcode.tag.contest.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 5663. 找出第 K 大的异或坐标值
 */
public class KthLargestValue {
    class Solution {
        int[][] meno;

        public int kthLargestValue(int[][] matrix, int k) {
            meno = new int[matrix.length][matrix[0].length];
            for (int[] ints : meno) {
                Arrays.fill(ints, -1);
            }

            List<Integer> list = new ArrayList<>();
            list.add(matrix[0][0]);
            meno[0][0] = matrix[0][0];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int zheng = zheng(matrix, i, j);
                    list.add(zheng);
                }
            }
            list.sort(Collections.reverseOrder());

            return list.get(k - 1);
        }

        private int zheng(int[][] matrix, int row, int col) {
            int v = 0;
            if (row == 0) {
                for (int i = 1; i <= col; i++) {
                    v = meno[row][i - 1] ^ matrix[row][i];
                }
            } else if (col == 0) {
                for (int i = 1; i <= row; i++) {
                    v = meno[i - 1][col] ^ matrix[i][col];
                }
            } else {
                for (int i = 1; i <= col; i++) {
                    v = meno[row - 1][col] ^ matrix[row][col];
                }
            }

            return v;
        }
    }
}
