package com.leetcode.tag.divide;

/**
 * 312. 戳气球
 *
 * <p>-1、两两划分
 */
public class BurstBalloons {
  /**
   * 想不出方程
   *
   * <p>这道题看起来最直接的做法就是暴力所有可能的扎破气球的顺序，但这个数量级很大，有 N×(N−1)×(N−2)×...×1 种可能，时间复杂度为
   *
   * <p>O(N!)。这种最直接的暴力会有很多重复计算，
   *
   * <p>比如有四个气球，你先扎破第一个再扎破第二个，跟你先扎破第二个在扎破第一个，
   *
   * <p>最后都是剩下第三个和第四个气球，
   *
   * <p>因此对于剩余第三个和第四个气球这种情况只需要计算一次就可以了。
   *
   * <p>有两种技巧可以继续优化解法：
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/burst-balloons/solution/chuo-qi-qiu-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int maxCoins(int[] nums) {
    return 0;
  }
}
