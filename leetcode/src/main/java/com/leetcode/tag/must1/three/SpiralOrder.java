package com.leetcode.tag.must1.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 */
public class SpiralOrder {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> list = new ArrayList<>();
            int m = matrix.length;
            if (m == 0) {
                return list;
            }
            int n = matrix[0].length;

            // 上边界
            int top = 0;
            // 下边界
            int bo = m - 1;
            // 左边界
            int left = 0;
            // 右边界
            int right = n - 1;

            int start = 1;
            int end = m * n;
            while (start <= end) {
                // 左到右
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                    start++;
                }
                // 上边界++
                top++;
                // 上到下
                for (int i = top; i <= bo; i++) {
                    list.add(matrix[i][right]);
                    start++;
                }
                // 右边界--
                right--;
                // 右到左
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bo][i]);
                    start++;
                }
                // 下边界--
                bo--;
                // 下到上
                for (int i = bo; i >= top; i--) {
                    list.add(matrix[i][left]);
                    start++;
                }
                // 左边界++
                left++;
            }

            return list;
        }
    }
}
