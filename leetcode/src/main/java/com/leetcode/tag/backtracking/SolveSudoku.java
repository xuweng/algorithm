package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 37. 解数独
 */
public class SolveSudoku {

  public void solveSudoku(char[][] board) {
    re(board, 0, 0);
  }

  /**
   * 按行填
   *
   * <p>先填满第一层,再填第二层......
   *
   * @param board
   * @param cow
   */
  public boolean re(char[][] board, int cow, int colum) {
    if (cow > board.length || colum > board[0].length) {
      return true;
    }
    List<Character> list = getUserd(board[cow]);
    for (int i = colum; i < board[0].length; i++) {
      if ('.' == board[cow][i] && list != null) {
        for (Character character : list) {
          board[cow][i] = character;
          if (!check(board, cow, i)) {
            board[cow][i] = '.';
            if (colum == board[0].length - 1) {
              return false;
            }
          } else {
            if (!re(board, cow, i + 1)) {
              board[cow][i] = '.';
            }
          }
        }
      }
    }
    return !isFull(board[cow]) || re(board, cow + 1, 0);
  }

  public boolean isFull(char[] chars) {
    for (char c : chars) {
      if ('.' == c) {
        return false;
      }
    }
    return true;
  }

  /**
   * 函数功能错误
   *
   * <p>行和列不能使用重复字符
   *
   * <p>返回还没使用过的数字
   *
   * @param chars
   * @return
   */
  public List<Character> getUserd(char[] chars) {
    String shu = "123456789";

    for (char c : chars) {
      if (Character.isDigit(c)) {
        shu = shu.replace(String.valueOf(c), "");
      }
    }
    List<Character> list = new ArrayList<>();
    for (int i = 0; i < shu.length(); i++) {
      list.add(shu.charAt(i));
    }
    return list;
  }

  /**
   * 检查board[cow][colum]是否合法
   *
   * @param board
   * @param cow
   * @param colum
   * @return
   */
  public boolean check(char[][] board, int cow, int colum) {
    // 检查第colum列
    HashSet<Character> hashSet = new HashSet<>();
    for (char[] chars : board) {
      if ('.' != chars[colum] && !hashSet.add(chars[colum])) {
        return false;
      }
    }
    // 检查3*3
    int[] index = getIndex(getFlag(cow), getFlag(colum));
    HashSet<Character> hashSet1 = new HashSet<>();
    for (int i = index[0]; i < index[0] + 3; i++) {
      for (int j = index[1]; j < index[1] + 3; j++) {
        if ('.' != board[i][j] && !hashSet1.add(board[i][j])) {
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

  /**
   * 作者：LeetCode 链接：https://leetcode-cn.com/problems/sudoku-solver/solution/jie-shu-du-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    // box size
    int n = 3;
    // row size
    int N = n * n;

    int[][] rows = new int[N][N + 1];
    int[][] columns = new int[N][N + 1];
    int[][] boxes = new int[N][N + 1];

    char[][] board;

    boolean sudokuSolved = false;

    /**
     * 检查(row,col)能不能放
     *
     * @param d
     * @param row
     * @param col
     * @return
     */
    public boolean couldPlace(int d, int row, int col) {
      /*
      Check if one could place a number d in (row, col) cell
      */
      int idx = (row / n) * n + col / n;
      return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    /**
     * 将 d 放入 (row, col) 格子中。 记录下 d 已经出现在当前行，列和子方块中。
     *
     * @param d
     * @param row
     * @param col
     */
    public void placeNumber(int d, int row, int col) {
      /*
      Place a number d in (row, col) cell
      */
      int idx = (row / n) * n + col / n;

      rows[row][d]++;
      columns[col][d]++;
      boxes[idx][d]++;
      board[row][col] = (char) (d + '0');
    }

    /**
     * 将d从 (row, col) 移除。
     *
     * @param d
     * @param row
     * @param col
     */
    public void removeNumber(int d, int row, int col) {
      /*
      Remove a number which didn't lead to a solution
      */
      int idx = (row / n) * n + col / n;
      rows[row][d]--;
      columns[col][d]--;
      boxes[idx][d]--;
      board[row][col] = '.';
    }

    /**
     * 放置接下来的数字
     *
     * @param row
     * @param col
     */
    public void placeNextNumbers(int row, int col) {
      /*
      Call backtrack function in recursion
      to continue to place numbers
      till the moment we have a solution
      */
      // if we're in the last cell
      // that means we have the solution
      // 如果这是最后一个格子row == 8, col == 8 ：
      // 意味着已经找出了数独的解。
      if ((col == N - 1) && (row == N - 1)) {
        sudokuSolved = true;
      } else {
        // if we're in the end of the row
        // go to the next row
        if (col == N - 1) {
          // 下一行
          backtrack(row + 1, 0);
        }
        // go to the next column
        else {
          // 下一列
          backtrack(row, col + 1);
        }
      }
    }

    /**
     * 从1 到 9 迭代循环数组，尝试放置数字 d 进入 (row, col) 的格子。
     *
     * <p>如果数字 d 还没有出现在当前行，列和子方块中：
     *
     * <p>将 d 放入 (row, col) 格子中。 记录下 d 已经出现在当前行，列和子方块中。
     *
     * <p>如果这是最后一个格子row == 8, col == 8 ： 意味着已经找出了数独的解。 否则 放置接下来的数字。
     *
     * <p>如果数独的解还没找到： 将最后的数从 (row, col) 移除。
     *
     * @param row
     * @param col
     */
    public void backtrack(int row, int col) {
      /*
      Backtracking
      */
      // if the cell is empty
      if (board[row][col] == '.') {
        // iterate over all numbers from 1 to 9
        // 尝试放1到9
        for (int d = 1; d < 10; d++) {
          // 检查
          if (couldPlace(d, row, col)) {
            // 放(row,col)
            placeNumber(d, row, col);
            // 放下一个
            placeNextNumbers(row, col);
            // if sudoku is solved, there is no need to backtrack
            // since the single unique solution is promised
            if (!sudokuSolved) {
              removeNumber(d, row, col);
            }
          }
        }
      } else {
        placeNextNumbers(row, col);
      }
    }

    public void solveSudoku(char[][] board) {
      this.board = board;

      // init rows, columns and boxes
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          char num = board[i][j];
          if (num != '.') {
            int d = Character.getNumericValue(num);
            placeNumber(d, i, j);
          }
        }
      }
      backtrack(0, 0);
    }
  }
}
