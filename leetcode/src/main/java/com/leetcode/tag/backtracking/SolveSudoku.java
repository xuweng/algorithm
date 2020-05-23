package com.leetcode.tag.backtracking;

import java.util.HashSet;

/**
 * 37. 解数独
 */
public class SolveSudoku {
  String shu = "123456789";

  public void solveSudoku(char[][] board) {}

  public char[] used(char[] chars) {
    for (char c : chars) {
      if (Character.isDigit(c)) {
        shu.replace(String.valueOf(c), "");
      }
    }
    return shu.toCharArray();
  }

  public boolean check(char[][] board, int cow, int colum) {
    // 检查第colum列
    HashSet<Character> hashSet = new HashSet<>();
    for (int i = 0; i < 9; i++) {
      if (!hashSet.add(board[i][colum])) {
        return false;
      }
    }
    // 检查3*3
    int[] index = getIndex(getFlag(cow), getFlag(colum));
    HashSet<Character> hashSet1 = new HashSet<>();
    for (int i = index[0]; i < index[0] + 3; i++) {
      for (int j = index[1]; j < index[1] + 3; j++) {
        if (!hashSet1.add(board[i][j])) {
          return false;
        }
      }
    }

    return true;
  }

  /**
   * 3*3分为9个区域
   *
   * <p>3*3在哪个区域
   *
   * <p>0--2.3--5.6--8
   *
   * @param i
   * @return
   */
  public int getFlag(int i) {
    int falg = 0;
    if (0 <= i && i <= 2) {
      falg = 1;
    } else if (3 <= i && i <= 5) {
      falg = 2;
    } else if (6 <= i && i <= 8) {
      falg = 3;
    }
    return falg;
  }

  /**
   * 根据区域返回区域左上的下标
   *
   * @param cowFalg
   * @param columFalg
   * @return
   */
  public int[] getIndex(int cowFalg, int columFalg) {
    int cow = 0;
    int colum = 0;
    if (cowFalg == 2) {
      cow = 3;
    } else if (cowFalg == 3) {
      cow = 6;
    }

    if (columFalg == 2) {
      colum = 3;
    } else if (columFalg == 3) {
      colum = 6;
    }

    return new int[]{cow, colum};
  }
}
