package com.leetcode.tag.dp;

/**
 * 递推式：
 *
 * <p>按照递推式写代码
 *
 * <p>f[i][j]= ⎩ ⎪ ⎨ ⎪ ⎧ ​
 *
 * <p>matrix[i][j] 0 min(f[i][j−1],f[i−1][j],f[i−1][j−1])+1 ​
 *
 * <p>,if i==0 or j==0 ,if matrix[i][j]==0 ,otherwise ​
 *
 * <p>作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/solution/tong-ji-quan-wei-1-de-zheng-fang-xing-zi-ju-zhen-2/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。 统计全为 1 的正方形子矩阵
 */
public class ZhengFangXingZiJuZhen {
  /**
   * 统计全为 1 的正方形子矩阵
   *
   * <p>我们用 f[i][j] 表示以 (i, j) 为右下角的正方形的最大边长，
   *
   * <p>那么除此定义之外，f[i][j] = x 也表示以 (i, j) 为右下角的正方形的数目为 x（即边长为 1, 2, ..., x 的正方形各一个）
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/solution/tong-ji-quan-wei-1-de-zheng-fang-xing-zi-ju-zhen-2/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param matrix
   * @return
   */
  public int countSquares(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int rows = matrix.length;
    int columns = matrix[0].length;
    int[][] dp = new int[rows][columns];
    int sum = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = matrix[i][j];
        } else if (matrix[i][j] == 0) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
        }
        sum += dp[i][j];
      }
    }

    return sum;
  }
}
