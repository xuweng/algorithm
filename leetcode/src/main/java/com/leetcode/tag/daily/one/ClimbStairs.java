package com.leetcode.tag.daily.one;

/**
 * 70. 爬楼梯
 */
public class ClimbStairs {
  int[] meno;

  public int climbStairs(int n) {
    meno = new int[n + 1];
    return re(n);
  }

  public int re(int n) {
    if (meno[n] != 0) {
      return meno[n];
    }
    // 终止条件
    if (n == 1 || n == 0) {
      return 1;
    }
    int result = re(n - 1) + re(n - 2);
    meno[n] = result;

    return result;
  }

  /**
   * 动态规划
   *
   * <p>但是由于这里的 f(x) 只和 f(x - 1) 与 f(x - 2) 有关，所以我们可以用「滚动数组思想」把空间复杂度优化成O(1)。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public int climbStairs(int n) {
      int p = 0, q = 0, r = 1;
      for (int i = 1; i <= n; ++i) {
        p = q;
        q = r;
        r = p + q;
      }
      return r;
    }
  }
}
