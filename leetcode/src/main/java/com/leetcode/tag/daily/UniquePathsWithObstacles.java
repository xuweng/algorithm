package com.leetcode.tag.daily;

/**
 * 63. 不同路径 II
 */
public class UniquePathsWithObstacles {
  private int count;

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid == null
            || obstacleGrid.length == 0
            || obstacleGrid[0][0] == 1
            || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
      return 0;
    }
    backTrack(obstacleGrid, 0, 0);

    return count;
  }

  public void backTrack(int[][] obstacleGrid, int row, int col) {
    if (row >= obstacleGrid.length || col >= obstacleGrid[0].length) {
      return;
    }
    if (row == obstacleGrid.length - 1
            && col == obstacleGrid[0].length - 1
            && obstacleGrid[row][col] != 1) {
      count++;
      return;
    }
    // 向右
    if (col + 1 < obstacleGrid[0].length && obstacleGrid[row][col + 1] != 1) {
      backTrack(obstacleGrid, row, col + 1);
    }
    // 向下
    if (row + 1 < obstacleGrid.length && obstacleGrid[row + 1][col] != 1) {
      backTrack(obstacleGrid, row + 1, col);
    }
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/unique-paths-ii/solution/bu-tong-lu-jing-ii-by-leetcode-solution-2/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    /**
     * 我们用f(i,j) 来表示从坐标(0,0) 到坐标 (i,j) 的路径总数
     *
     * <p>f(i,j)=0 u(i,j)=0
     *
     * <p>f(i,j)=f(i,j-1)+f(i-1,j) u(i,j)!=0
     *
     * <p>这里f(i,j) 只与f(i−1,j) 和 f(i,j−1) 相关，我们可以运用「滚动数组思想」把空间复杂度优化称
     *O(m)。「滚动数组思想」是一种常见的动态规划优化方法，在我们的题目中已经多次使用到，
     * 例如「剑指 Offer 46. 把数字翻译成字符串」、「70.爬楼梯」等，
     * 当我们定义的状态在动态规划的转移方程中只和某几个状态相关的时候，
     * 就可以考虑这种优化方法，目的是给空间复杂度「降维」。如果你还不知道什么是「滚动数组思想」，一定要查阅相关资料进行学习哦。
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      int n = obstacleGrid.length, m = obstacleGrid[0].length;
      int[] f = new int[m];

      f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
      for (int[] ints : obstacleGrid) {
        for (int j = 0; j < m; ++j) {
          if (ints[j] == 1) {
            f[j] = 0;
            continue;
          }
          if (j - 1 >= 0 && ints[j - 1] == 0) {
            f[j] += f[j - 1];
          }
        }
      }

      return f[m - 1];
    }
  }
}
