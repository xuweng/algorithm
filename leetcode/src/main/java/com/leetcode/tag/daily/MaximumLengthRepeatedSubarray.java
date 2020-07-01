package com.leetcode.tag.daily;

/**
 * 718. 最长重复子数组
 *
 * <p>是否连续?
 *
 * <p>是否连续？
 *
 * <p>是否连续？
 *
 * <p>子数组一定连续。子串一定连续。
 */
public class MaximumLengthRepeatedSubarray {
  /**
   * 需要注意到数组长度不超过 1000，且子数组在原数组中连续。
   *
   * <p>容易想到一个暴力解法，即枚举数组 A 中的起始位置 i 与数组 B 中的起始位置 j，
   *
   * <p>然后计算 A[i:] 与 B[j:] 的最长公共前缀 k。最终答案即为所有的最长公共前缀的最大值。
   *
   * <p>最坏时间复杂度为 O(n^3)
   *
   * @param A
   * @param B
   * @return
   */
  public int findLength(int[] A, int[] B) {
    // 排序不对。改变原来的顺序。不是子数组。
    //    Arrays.sort(A);
    //    Arrays.sort(B);

    return 0;
  }

  /**
   * dp:小---->大。自底向上
   *
   * <p>递归:大--->小。自顶向下
   *
   * <p>长度最长。最优解。容易想到dp。
   *
   * <p>计算顺序?
   *
   * <p>定义状态
   *
   * <p>状态转移方程?不能简单的递推。
   *
   * @param A
   * @param B
   * @return
   */
  public int dp(int[] A, int[] B) {
    int[][] dpMax = new int[A.length][B.length];
    return dpMax[A.length - 1][B.length - 1];
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zui-chang-zhong-fu-zi-shu-zu-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    /**
     * 不是前i个?
     *
     * <p>A[i:] 表示数组 A 中索引 i 到数组末尾的范围对应的子数组
     *
     * <p>令 dp[i][j] 表示 A[i:] 和 B[j:] 的最长公共前缀，那么答案即为所有 dp[i][j] 中的最大值
     *
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
      int n = A.length, m = B.length;
      int[][] dp = new int[n + 1][m + 1];
      int ans = 0;
      for (int i = n - 1; i >= 0; i--) {
        for (int j = m - 1; j >= 0; j--) {
          dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
          ans = Math.max(ans, dp[i][j]);
        }
      }
      return ans;
    }
  }
}
