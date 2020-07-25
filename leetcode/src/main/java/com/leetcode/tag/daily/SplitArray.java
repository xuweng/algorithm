package com.leetcode.tag.daily;

import java.util.Arrays;

/**
 * 410. 分割数组的最大值
 *
 * <p>dp。一定要明确原问题。从原问题中提取变量作为dp的状态。如：隐含的状态包括数组长度、字符串长度。然后枚举dp的每个状态。
 *
 * <p>方法最重要。dp题目的解法、方法最重要。不要死记硬背某一道dp算法题。
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
   * <p>枚举dp每个状态的范围。枚举i的范围，枚举j的范围。
   *
   * <p>i的范围很明显：1~n；j的范围？
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
      // 前缀和
      int[] sub = new int[n + 1];
      for (int i = 0; i < n; i++) {
        sub[i + 1] = sub[i] + nums[i];
      }
      f[0][0] = 0;
      // 枚举i的范围
      for (int i = 1; i <= n; i++) {
        // 枚举j的范围
        // 即我们可以枚举 k，其中前 k 个数被分割为 j−1 段，而第 k+1 到第 i 个数为第 j 段
        for (int j = 1; j <= Math.min(i, m); j++) {
          for (int k = 0; k < i; k++) {
            // m 个子数组各自和的最大值最小。有点腰。和的最大值。和的最大值。
            f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
          }
        }
      }
      return f[n][m];
    }
  }
}
