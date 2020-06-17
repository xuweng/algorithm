package com.leetcode.tag.daily;

/**
 * 看动画搞懂题解
 *
 * <p>看动画搞懂题解
 *
 * <p>看动画搞懂题解
 *
 * <p>数据结构?
 *
 * <p>考查什么？
 *
 * <p>考查什么？
 *
 * <p>考查什么？
 *
 * <p>考查什么？
 *
 * <p>1014. 最佳观光组合
 */
public class MaxScoreSightseeingPair {
  /**
   * 暴力时间复杂度为O(n2)
   *
   * <p>暴力时间复杂度
   *
   * <p>暴力时间复杂度
   *
   * <p>暴力时间复杂度
   *
   * <p>暴力时间复杂度
   *
   * @param A
   * @return
   */
  public int maxScoreSightseeingPair(int[] A) {
    return 0;
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/best-sightseeing-pair/solution/zui-jia-guan-guang-zu-he-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    /**
     * 这道题没什么意义
     *
     * <p>这道题没什么意义
     *
     * <p>这道题没什么意义
     *
     * <p>这道题没什么意义
     *
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
      int ans = 0, mx = A[0] + 0;
      for (int j = 1; j < A.length; ++j) {
        // 当前是j
        ans = Math.max(ans, mx + A[j] - j);
        // 边遍历边维护
        mx = Math.max(mx, A[j] + j);
      }
      return ans;
    }
  }
}
