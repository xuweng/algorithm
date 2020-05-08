package com.leetcode.tag.daily;

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
}
