package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 算法模板
 *
 * <p>算法模板
 *
 * <p>算法模板
 *
 * <p>算法模板
 *
 * <p>算法模板
 *
 * <p>算法模板
 *
 * <p>算法模板
 *
 * <p>十分钟看图解
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

    for (String s : words) {
      if (findWords(board, s)) {
        result.add(s);
      }
    }

    return result;
  }

  public boolean findWords(char[][] board, String word) {
    // 一条路径不能重复访问
    boolean[][] visited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] != word.charAt(0)) {
          continue;
        }
        if (backTrack(board, "", word, i, j, visited)) {
          return true;
        }
      }
    }

    return false;
  }

  public boolean backTrack(
          char[][] board, String temp, String word, int row, int col, boolean[][] visited) {
    if (temp.length() > 1 && !word.contains(temp)) {
      return false;
    }
    // 越界统计
    if (row < 0
            || row >= board.length
            || col < 0
            || col >= board[0].length
            || temp.length() == word.length()) {
      return word.equals(temp);
    }
    if (!visited[row][col]) {
      visited[row][col] = true;
      if (backTrack(board, temp + board[row][col], word, row - 1, col, visited)) {
        return true;
      }
      visited[row][col] = false;
    }
    if (!visited[row][col]) {
      visited[row][col] = true;
      if (backTrack(board, temp + board[row][col], word, row + 1, col, visited)) {
        return true;
      }
      visited[row][col] = false;
    }
    if (!visited[row][col]) {
      visited[row][col] = true;
      if (backTrack(board, temp + board[row][col], word, row, col - 1, visited)) {
        return true;
      }
      visited[row][col] = false;
    }
    if (!visited[row][col]) {
      visited[row][col] = true;
      if (backTrack(board, temp + board[row][col], word, row, col + 1, visited)) {
        return true;
      }
      visited[row][col] = false;
    }
    return false;
  }
}
