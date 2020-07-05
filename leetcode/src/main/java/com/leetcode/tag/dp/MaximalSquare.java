package com.leetcode.tag.dp;

/**
 * 221. 最大正方形
 */
public class MaximalSquare {
  class Solution {
    public int maximalSquare(char[][] matrix) {
      int maxSide = 0;
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return maxSide;
      }
      int rows = matrix.length, columns = matrix[0].length;
      int[][] dp = new int[rows][columns];
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          if (matrix[i][j] == '1') {
            if (i == 0 || j == 0) {
              dp[i][j] = 1;
            } else {
              dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
            maxSide = Math.max(maxSide, dp[i][j]);
          }
        }
      }
      return maxSide * maxSide;
    }
  }

  /**
   * 方法一：暴力法
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    public int maximalSquare(char[][] matrix) {
      // 正方形的边
      int maxSide = 0;
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return maxSide;
      }
      int rows = matrix.length, columns = matrix[0].length;
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          if (matrix[i][j] == '0') {
            continue;
          }
          // 遇到一个 1 作为正方形的左上角
          maxSide = Math.max(maxSide, 1);
          // 计算可能的最大正方形边长
          int currentMaxSide = Math.min(rows - i, columns - j);
          for (int k = 1; k < currentMaxSide; k++) {
            // 判断新增的一行一列是否均为 1
            if (matrix[i + k][j + k] == '0') {
              // 右下角==0
              break;
            }
            // 右下角!=0
            // 判断子正方形是否包含0
            boolean flag = true;
            for (int m = 0; m < k; m++) {
              if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                flag = false;
                break;
              }
            }
            if (flag) {
              // 子正方形不包含0
              maxSide = Math.max(maxSide, k + 1);
            } else {
              break;
            }
          }
        }
      }
      return maxSide * maxSide;
    }
  }
}
