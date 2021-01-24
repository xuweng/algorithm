package com.leetcode.tag.contest.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 5663. 找出第 K 大的异或坐标值
 */
public class KthLargestValue {
    class Solution {
        public int kthLargestValue(int[][] matrix, int k) {
            List<Integer> list = new ArrayList<>();
            list.add(matrix[0][0]);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    list.add(zheng(matrix, i, j));
                }
            }
            list.sort(Collections.reverseOrder());

            return list.get(k - 1);
        }

        private int zheng(int[][] matrix, int start, int end) {
            int pre = matrix[0][0];
            for (int i = 0; i <= start; i++) {
                for (int j = 0; j <= end; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int v = pre ^ matrix[i][j];
                    pre = v;
                }
            }

            return pre;
        }
    }
}
