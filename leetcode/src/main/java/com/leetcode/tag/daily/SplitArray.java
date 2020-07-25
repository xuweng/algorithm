package com.leetcode.tag.daily;

import java.util.Arrays;

/**
 * 410. 分割数组的最大值
 *
 * <p>不能用穷举
 *
 * <p>不能用穷举
 *
 * <p>不能用穷举
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 */
public class SplitArray {
  class Solution {
    public int splitArray(int[] nums, int m) {
      return 0;
    }
  }

  /**
   * 方法一：动态规划
   *
   * <p>思路与算法
   *
   * <p>「将数组分割为 m 段，求……」是动态规划题目常见的问法。
   *
   * <p>我怎么没有想到。我怎么没有想到。我怎么没有想到。
   *
   * <p>分割为m段。题目提示。题目暗示。
   *
   * <p>原题目：将这个数组分成 m 个非空的连续子数组。
   *
   * <p>数组长度为n。
   *
   * <p>原问题：将前n个数（长度为n）分割为m个非空的连续子数组
   *
   * <p>原问题。原问题。原问题。原问题。原问题。
   *
   * <p>令f[i][j] 表示将数组的前 i 个数分割为 j 段所能得到的最大连续子数组和的最小值
   *
   * <p>枚举i的范围，枚举j的范围。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/split-array-largest-sum/solution/fen-ge-shu-zu-de-zui-da-zhi-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    public int splitArray(int[] nums, int m) {
      int n = nums.length;
      int[][] f = new int[n + 1][m + 1];
      for (int i = 0; i <= n; i++) {
        Arrays.fill(f[i], Integer.MAX_VALUE);
      }
      int[] sub = new int[n + 1];
      for (int i = 0; i < n; i++) {
        sub[i + 1] = sub[i] + nums[i];
      }
      f[0][0] = 0;
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= Math.min(i, m); j++) {
          for (int k = 0; k < i; k++) {
            f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
          }
        }
      }
      return f[n][m];
    }
  }
}
