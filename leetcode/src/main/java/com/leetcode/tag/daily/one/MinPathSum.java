package com.leetcode.tag.daily.one;

/**
 * 64. 最小路径和
 */
public class MinPathSum {
  class Solution {
    public int minPathSum(int[][] grid) {
      if (grid == null || grid.length == 0) {
        return 0;
      }
      int[][] dp = new int[grid.length][grid[0].length];
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          if (i == 0) {
            dp[i][j] = (j == 0) ? grid[i][j] : dp[i][j - 1] + grid[i][j];
          } else if (j == 0) {
            dp[i][j] = dp[i - 1][j] + grid[i][j];
          } else {
            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
          }
        }
      }

      return dp[grid.length - 1][grid[0].length - 1];
    }
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    public int minPathSum(int[][] grid) {
      if (grid == null || grid.length == 0 || grid[0].length == 0) {
        return 0;
      }
      int rows = grid.length, columns = grid[0].length;
      int[][] dp = new int[rows][columns];
      dp[0][0] = grid[0][0];
      for (int i = 1; i < rows; i++) {
        dp[i][0] = dp[i - 1][0] + grid[i][0];
      }
      for (int j = 1; j < columns; j++) {
        dp[0][j] = dp[0][j - 1] + grid[0][j];
      }
      for (int i = 1; i < rows; i++) {
        for (int j = 1; j < columns; j++) {
          dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        }
      }
      return dp[rows - 1][columns - 1];
    }
  }
}
