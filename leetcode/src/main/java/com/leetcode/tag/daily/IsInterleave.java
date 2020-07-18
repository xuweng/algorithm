package com.leetcode.tag.daily;

/**
 * 97. 交错字符串
 *
 * <p>计数dp
 *
 * <p>最优解dp
 *
 * <p>是否dp
 */
public class IsInterleave {
  /**
   * 思路与算法
   *
   * <p>双指针法?
   *
   * <p>dp
   *
   * <p>首先如果∣s1∣+∣s2∣​ =∣s3∣，那s3 ​必然不可能由 s1 s2 ​交错组成。在 ∣s1∣+∣s2∣=∣s3∣ 时
   *
   * <p>我们可以用动态规划来求解。我们定义 f(i,j) 表示 s1 的前 i个元素和 s2 ​的前 j 个元素是否能交错组成 s3 ​的前i+j 个元素。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/interleaving-string/solution/jiao-cuo-zi-fu-chuan-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
      return true;
    }
  }
}
