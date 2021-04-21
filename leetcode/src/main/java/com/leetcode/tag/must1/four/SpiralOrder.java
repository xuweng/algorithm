package com.leetcode.tag.must1.four;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 */
public class SpiralOrder {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int top = 0;
            int bo = m - 1;
            int left = 0;
            int right = n - 1;

            List<Integer> result = new ArrayList<>();
            int start = 1;
            int end = m * n;
            while (start <= end) {
                // 左到右
                for (int i = left; i <= right && start <= end; i++) {
                    result.add(matrix[top][i]);
                    start++;
                }
                top++;
                // 上到下
                for (int i = top; i <= bo && start <= end; i++) {
                    result.add(matrix[i][right]);
                    start++;
                }
                right--;
                // 右到左
                for (int i = right; i >= left && start <= end; i--) {
                    result.add(matrix[bo][i]);
                    start++;
                }
                bo--;
                // 下到上
                for (int i = bo; i >= top && start <= end; i--) {
                    result.add(matrix[i][left]);
                    start++;
                }
                left++;
            }

            return result;
        }
    }
}
