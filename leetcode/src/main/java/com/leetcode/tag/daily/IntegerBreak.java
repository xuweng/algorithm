package com.leetcode.tag.daily;

/**
 * 343. 整数拆分
 */
public class IntegerBreak {
  /**
   * 获得的最大乘积
   *
   * <p>最优dp。最优dp。
   */
  class Solution {
    public int integerBreak(int n) {
      return 0;
    }
  }

  /**
   * 令 k 是拆分出的第一个正整数，则剩下的部分是 n−k
   *
   * <p>可以不继续拆分，或者继续拆分成至少两个正整数的和。由于每个正整数对应的最大乘积取决于比它小的正整数对应的最大乘积，
   *
   * <p>因此可以使用动态规划求解。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/integer-break/solution/zheng-shu-chai-fen-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    /**
     * dp[i] 表示将正整数 i 拆分成至少两个正整数的和之后，这些正整数的最大乘积
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
      int[] dp = new int[n + 1];
      for (int i = 2; i <= n; i++) {
        int curMax = 0;
        for (int j = 1; j < i; j++) {
          curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
        }
        dp[i] = curMax;
      }
      return dp[n];
    }
  }
}
