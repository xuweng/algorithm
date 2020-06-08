package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 十分钟看图解
 *
 * <p>十分钟看图解
 *
 * <p>十分钟看图解
 *
 * <p>十分钟看题解
 *
 * <p>十分钟看题解
 *
 * <p>十分钟看题解
 *
 * <p>搞懂所有示例
 *
 * <p>搞懂所有示例。搞懂所有示例。搞懂所有示例。搞懂所有示例
 *
 * <p>212. 单词搜索 II
 */
public class FindWords {
  /**
   * 算法框架
   *
   * @param board
   * @param words
   * @return
   */
  public List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();
    if (board == null || board.length == 0) {
      return result;
    }
    boolean[][] visited = new boolean[board.length][board[0].length];

    for (String s : words) {
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
          if (board[i][j] != s.charAt(0)) {
            continue;
          }
          backTrack(board, s, i, j, 0, visited, result);
        }
      }
    }

    return result;
  }

  public void backTrack(
          char[][] board,
          String word,
          int row,
          int col,
          int index,
          boolean[][] visited,
          List<String> result) {
    visited[row][col] = true;
  }
}
