package com.leetcode.tag.daily.one;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 221. 最大正方形
 *
 * <p>矩阵搜索.矩阵搜索.矩阵搜索.矩阵搜索
 *
 * <p>广度优先.深度优先
 *
 * <p>考什么.这道题考什么.这道题考什么
 *
 * <p>考搜索.考搜索
 */
public class MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    int result = 0;
    // 只有1行
    if (matrix.length <= 1) {
      for (int i = 0; i < matrix[0].length; i++) {
        result = Math.max(result, matrix[0][i]);
      }
    }
    for (int i = 0; i < matrix.length - 1; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        result = Math.max(result, check(matrix, i, j));
      }
    }
    return result;
  }

  /**
   * 检查每个点面积
   *
   * <p>广度.深度
   *
   * @param i
   * @param j
   * @return
   */
  public int check(char[][] matrix, int i, int j) {
    if (matrix[i][j] == '0') {
      return 0;
    }
    Queue<Integer[]> queue = new LinkedList<>();
    boolean[][] visitied = new boolean[matrix.length][matrix[0].length];
    // 添加元素
    Integer[] xiaBiao = {i, j};
    queue.offer(xiaBiao);
    visitied[i][j] = true;
    Integer[] integers = null;
    while (!queue.isEmpty()) {
      // 返回第一个元素，并在队列中删除
      integers = queue.poll();
      // 行
      int h = integers[0] + 1;
      // 列
      int l = integers[1] + 1;
      if (h >= matrix.length || l >= matrix[0].length) {
        break;
      }

      char you = matrix[integers[0]][l];
      char xia = matrix[h][integers[1]];
      if (you == '0' || xia == '0') {
        break;
      }

      if (!visitied[integers[0]][l] && !visitied[h][integers[1]]) {
        Integer[] y = {integers[0], l};
        Integer[] x = {h, integers[1]};

        queue.offer(y);
        queue.offer(x);
      }
    }
    int juLi = Math.max(integers[0] - i, integers[1] - j);

    return (juLi + 1) * (juLi + 1);
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    /**
     * 感觉没学到什么
     *
     * <p>感觉没学到什么
     *
     * <p>感觉没学到什么
     *
     * <p>暴力法是最简单直观的做法
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
      int maxSide = 0;
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return maxSide;
      }
      // 行
      int rows = matrix.length;
      // 列
      int columns = matrix[0].length;
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          if (matrix[i][j] == '1') {
            // 遇到一个 1 作为正方形的左上角
            maxSide = Math.max(maxSide, 1);
            // 计算可能的最大正方形边长
            int currentMaxSide = Math.min(rows - i, columns - j);
            for (int k = 1; k < currentMaxSide; k++) {
              // 判断新增的一行一列是否均为 1
              boolean flag = true;
              if (matrix[i + k][j + k] == '0') {
                break;
              }
              for (int m = 0; m < k; m++) {
                if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                  flag = false;
                  break;
                }
              }
              if (flag) {
                maxSide = Math.max(maxSide, k + 1);
              } else {
                break;
              }
            }
          }
        }
      }
      return maxSide * maxSide;
    }
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    /**
     * 学习动态规划
     *
     * <p>学习动态规划
     *
     * <p>学习动态规划
     *
     * <p>学习动态规划
     *
     * <p>通过固定 f[i][j] 的值，判断其相邻位置与之的关系得到的不等式
     *
     * <p>原问题:找到只包含 1 的最大正方形的面积。
     *
     * <p>我们用 dp(i,j) 表示以 (i,j) 为右下角，且只包含 1 的正方形的边长最大值
     *
     * @param matrix
     * @return
     */
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
}
