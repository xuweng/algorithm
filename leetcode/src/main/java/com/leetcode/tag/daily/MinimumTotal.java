package com.leetcode.tag.daily;

import java.util.List;

/**
 * 120. 三角形最小路径和
 */
public class MinimumTotal {
  /**
   * 一道非常经典且历史悠久的动态规划题
   *
   * <p>最小路径和
   *
   * <p>dp
   */
  class Solution {
    /**
     * 思路与算法
     *
     * <p>形成一个等腰直角三角形
     *
     * <p>f[i][j] 表示从三角形顶部走到位置 (i,j) 的最小路径和
     *
     * <p>f[i][j]=min(f[i−1][j−1],f[i−1][j])+c[i][j]
     *
     * <p>两个特殊情况:
     *
     * <p>f[i][0]=f[i−1][0]+c[i][0]
     *
     * <p>f[i][i]=f[i−1][i−1]+c[i][i]
     *
     * <p>最终的答案即为f[n−1][0] 到 f[n−1][n−1] 中的最小值
     *
     * <p>思路与算法想好了
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
      return 0;
    }
  }

  /**
   * 思路与算法想好了再写代码效率很高
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/triangle/solution/san-jiao-xing-zui-xiao-lu-jing-he-by-leetcode-solu/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
      int n = triangle.size();
      int[][] f = new int[n][n];
      // 即在三角形的顶部时，最小路径和就等于对应位置的元素值
      f[0][0] = triangle.get(0).get(0);
      for (int i = 1; i < n; ++i) {
        // 在里面初始化特殊情况。注意计算顺序
        f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
        for (int j = 1; j < i; ++j) {
          f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
        }
        // 在里面初始化特殊情况
        f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
      }
      int minTotal = f[n - 1][0];
      for (int i = 1; i < n; ++i) {
        minTotal = Math.min(minTotal, f[n - 1][i]);
      }
      return minTotal;
    }
  }
}
