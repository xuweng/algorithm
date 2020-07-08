package com.leetcode.tag.daily;

/**
 * 面试题 16.11. 跳水板
 */
public class DivingBoard {
  /**
   * 方法一：数学
   *
   * <p>时间复杂度：O(k)，其中 k 是木板数量。短木板和长木板一共使用 k 块，一共有 k+1 种组合，对于每种组合都要计算跳水板的长度。
   *
   * <p>空间复杂度：O(1)。除了返回值以外，额外使用的空间复杂度为常数。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/diving-board-lcci/solution/tiao-shui-ban-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
      if (k == 0) {
        return new int[0];
      }
      if (shorter == longer) {
        return new int[]{shorter * k};
      }
      int[] lengths = new int[k + 1];
      for (int i = 0; i <= k; i++) {
        lengths[i] = shorter * (k - i) + longer * i;
      }
      return lengths;
    }
  }
}
