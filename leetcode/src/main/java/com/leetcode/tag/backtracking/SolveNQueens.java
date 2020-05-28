package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 面试题 08.12. 八皇后
 */
public class SolveNQueens {
  public List<List<String>> solveNQueens(int n) {
    return null;
  }

  /**
   * 作者：Mrzhp 链接：https://leetcode-cn.com/problems/eight-queens-lcci/solution/javahui-su-by-mrzhp/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public List<List<String>> solveNQueens(int n) {
      List<List<String>> list = new ArrayList<>();
      back(0, list, n, new int[n]);
      return list;
    }

    /**
     * record数组记录每一行哪个位置插入皇后
     *
     * @param cow 行
     * @param lists
     * @param n 最后一行+1
     * @param record
     */
    public void back(int cow, List<List<String>> lists, int n, int[] record) { // record也可以是二维数组记录位置
      if (cow == n) {
        // 打印函数
        print(lists, record);
        return;
      }
      for (int j = 0; j < n; j++) {
        // 该位置是否满足条件（不同行，不同列，不同斜线）
        // 剪枝.先判断
        if (!isValid(record, cow, j)) {
          continue;
        }
        // 当前cow放j
        record[cow] = j;
        back(cow + 1, lists, n, record);
      }
    }

    private boolean isValid(int[] record, int i, int j) {
      for (int k = 0; k < i; k++) {
        if (j == record[k] || Math.abs(i - k) == Math.abs(record[k] - j)) { // 斜率不为1或者-1
          return false;
        }
      }
      return true;
    }

    private void print(List<List<String>> list, int[] record) { // record中记录的皇后位置还原
      List<String> strings = new ArrayList<>();
      for (int value : record) {
        // int j = record[i];
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < record.length; j++) {
          if (j == value) {
            stringBuilder.append("Q");
          } else {
            stringBuilder.append(".");
          }
        }
        strings.add(stringBuilder.toString());
      }
      list.add(strings);
    }
  }

  /**
   * 就学这个
   *
   * <p>代码思路清晰.代码逻辑清晰.看懂才有用.
   *
   * <p>利用回溯的解法
   *
   * <p>先生成 n * n的二维数组，数组元素用 . 来填充
   *
   * <p>每一轮循环，把Q 依次放在 0 ~ n的位置
   *
   * <p>判断在每个位置的时候是否满足竖的 和 左 右对角线没有其他的 Q。若不满足直接跳出
   *
   * <p>探索下一个位置 找到满足的位置后继续探索下一层。
   *
   * <p>重复 2-4 知道满足找到最后一行
   *
   * <p>作者：ckhero
   * 链接：https://leetcode-cn.com/problems/eight-queens-lcci/solution/jie-jin-shuang-bai-by-ckhero/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    public List<List<String>> solveNQueens(int n) {
      List<List<String>> ans = new ArrayList<>();
      List<String> path = new ArrayList<>();
      // 初始化nums
      char[][] nums = new char[n][n];
      for (int i = 0; i < n; i++) {
        Arrays.fill(nums[i], '.');
      }

      backtrack(nums, 0, ans);

      return ans;
    }

    private void backtrack(char[][] nums, int currRow, List<List<String>> ans) {
      int len = nums.length;
      if (currRow == len) {
        ans.add(Arrays.stream(nums).map(String::valueOf).collect(toList()));
        return;
      }

      for (int col = 0; (currRow < len) && (col < nums[0].length); col++) {
        if (!isValid(nums, currRow, col)) {
          continue;
        }
        // 满足条件
        // 当前位置填Q
        nums[currRow][col] = 'Q';
        backtrack(nums, currRow + 1, ans);
        // 撤销状态
        nums[currRow][col] = '.';
      }
    }

    /**
     * 检查currRow上的所有行
     *
     * @param nums
     * @param currRow
     * @param col
     * @return
     */
    public boolean isValid(char[][] nums, int currRow, int col) {
      for (int row = 0; row < currRow; row++) {
        // 列有Q
        if (nums[row][col] == 'Q') {
          return false;
        }
        // 判断对角线
        if (col + (currRow - row) < nums.length && nums[row][col + (currRow - row)] == 'Q') {
          return false;
        }
        if (col - (currRow - row) >= 0 && nums[row][col - (currRow - row)] == 'Q') {
          return false;
        }
      }
      return true;
    }
  }
}
