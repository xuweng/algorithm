package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
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
      // 一定是这样return
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

  /**
   * 灵活使用数据结构
   *
   * <p>灵活使用数据结构
   *
   * <p>灵活使用数据结构
   *
   * <p>灵活使用数据结构
   *
   * <p>方法一：使用前缀树的回溯
   *
   * <p>十分钟看题解
   *
   * <p>十分钟看题解
   *
   * <p>十分钟看题解
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/word-search-ii/solution/dan-ci-sou-suo-ii-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    String word = null;

    public TrieNode() {
    }
  }

  class Solution {
    char[][] _board = null;
    ArrayList<String> _result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

      // Step 1). Construct the Trie
      TrieNode root = new TrieNode();
      for (String word : words) {
        TrieNode node = root;

        for (Character letter : word.toCharArray()) {
          if (node.children.containsKey(letter)) {
            node = node.children.get(letter);
          } else {
            TrieNode newNode = new TrieNode();
            node.children.put(letter, newNode);
            node = newNode;
          }
        }
        node.word = word; // store words in Trie
      }

      this._board = board;
      // Step 2). Backtracking starting for each cell in the board
      for (int row = 0; row < board.length; ++row) {
        for (int col = 0; col < board[row].length; ++col) {
          if (root.children.containsKey(board[row][col])) {
            backtracking(row, col, root);
          }
        }
      }

      return this._result;
    }

    private void backtracking(int row, int col, TrieNode parent) {
      Character letter = this._board[row][col];
      TrieNode currNode = parent.children.get(letter);

      // check if there is any match
      if (currNode.word != null) {
        this._result.add(currNode.word);
        currNode.word = null;
      }

      // mark the current letter before the EXPLORATION
      this._board[row][col] = '#';

      // explore neighbor cells in around-clock directions: up, right, down, left
      int[] rowOffset = {-1, 0, 1, 0};
      int[] colOffset = {0, 1, 0, -1};
      for (int i = 0; i < 4; ++i) {
        int newRow = row + rowOffset[i];
        int newCol = col + colOffset[i];
        if (newRow < 0
                || newRow >= this._board.length
                || newCol < 0
                || newCol >= this._board[0].length) {
          continue;
        }
        if (currNode.children.containsKey(this._board[newRow][newCol])) {
          backtracking(newRow, newCol, currNode);
        }
      }

      // End of EXPLORATION, restore the original letter in the board.
      this._board[row][col] = letter;

      // Optimization: incrementally remove the leaf nodes
      if (currNode.children.isEmpty()) {
        parent.children.remove(letter);
      }
    }
  }
}
