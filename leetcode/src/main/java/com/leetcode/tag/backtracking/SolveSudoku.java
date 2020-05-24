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
  static class Solution {
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
     * 回溯算法模板:
     *
     * <p>当前能放?---->放----->回溯----->有解?---->有---->结束
     *
     * <p>当前能放?---->放----->回溯----->有解?---->无---->删除当前已放----->下一个分支
     *
     * <p>从1 到 9 迭代循环数组，尝试放置数字 d 进入 (row, col) 的格子。
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
              // 用变量来记录是否有解
              // 如果没有解就删除已经放的数字
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

  class S {
    /**
     * 回溯
     * 回溯解法：https://leetcode-cn.com/problems/sudoku-solver/solution/zi-cong-wo-xue-hui-liao-hui-su-suan-fa-zhong-yu-hu/
     * 逐行，从左到右，在每一个位置上试探1-9，成功就进入下一个位置，失败就取消本次选择，做下一个选择 当前行试探完毕就换行，知道换到最后一行
     *
     * @param board
     */
    public void solution(char[][] board) {
      // 非法数独
      if (board == null || board.length != 9 || board[0] == null || board[0].length != 9) {
        return;
      }
      // 回溯法解决
      backTrace(board, 0, 0);
    }

    private boolean backTrace(char[][] board, int row, int col) {
      int n = board.length; // 9
      // 当前行已全部试探过，换到下一行第一个位置
      if (col == 9) {
        return backTrace(board, row + 1, 0);
      }
      // 满足结束条件，全部行全部位置都已试探过
      // 最后一行最后一个位置[8][8]试探过后会试探[8][9]，会执行[9][0]，返回
      if (row == n) {
        return true;
      }
      // 这个位置数字已给出，不需要试探，直接试探下一个位置
      if (board[row][col] != '.') {
        return backTrace(board, row, col + 1);
      }
      // (row,col)有9个选择
      // 遍历可选择列表(各选择之间并列)
      for (char c = '1'; c <= '9'; c++) {
        // 排除不合法的选择
        if (!isValid(board, row, col, c)) {
          continue;
        }
        // 做选择
        board[row][col] = c;
        // 进行下一步试探，发现当前选择能成功进行下去，就继续往下
        if (backTrace(board, row, col + 1)) {
          return true;
        }
        // 撤销本次选择，并列进行下一次选择的试探
        board[row][col] = '.';
      }
      // 这个位置把1-9都试过了，都无法继续下去，说明上一次的选择失败，需要回溯
      return false;
    }

    /**
     * 判断 board[row][col]位置放入字符 ch,是否合理 也就判断这个字符有没有在 同一行，同一列，同一个子数独中出现过 行列比较容易，就是一个for循环 而对于 给定的
     * board[i][j]，它所在的子数独的索引是 (i / 3) * 3 + j / 3 要扫描这个子数独中的全部9个元素，for循环可以这样写 boardIndex = (i / 3)
     * * 3 + j / 3 for(int k = 0; k < 9; k++){ board[(i/3)*3 + k/3][(j/3)*3 + k % 3] } 因为 i和j是确定的，所以
     * i / 3 * 3可以确定他所在的子数独在第一个三行，还是第二个三行，还是第三个三行 j / 3 * 3可以确定它所在的子数独是前三列还是中散列还是后三列，
     * 相当于这两个只是确定了这个【子数独的左上角坐标】，而需要借助 k 完全对这个9个位置的扫描
     *
     * @param board
     * @param row
     * @param col
     * @param ch
     * @return
     */
    private boolean isValid(char[][] board, int row, int col, char ch) {
      // 三个方向，任一方向重复，ch就不能放在这个位置
      for (int k = 0; k < 9; k++) {
        // 同一行九个位置已出现 ch
        if (board[row][k] == ch) {
          return false;
        }
        // 同一列九个位置中已出现 ch
        if (board[k][col] == ch) {
          return false;
        }
        // 同一个子数独九个位置中已出现 ch
        if (board[(row / 3) * 3 + k / 3][(col / 3) * 3 + k % 3] == ch) {
          return false;
        }
      }
      return true;
    }
  }
}
