package com.leetcode.tag.recursive;

/**
 * 官方:第K个语法符号
 */
public class g779 {
  /**
   * 递归 (父子递推)
   *
   * <p>复杂度分析
   *
   * <p>时间复杂度： O(N)。 空间复杂度： O(1)。
   *
   * <p>数据规模减少1.一个子问题。
   *
   * <p>据此可以总结出规律，第 K 个数字是上一行第 (K+1) / 2 个数字生成的。如果上一行的数字为 0，被生成的数字为 1 - (K%2)， 如果上一行的数字为
   * 1，被生成的数字为K%2。
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/k-th-symbol-in-grammar/solution/di-kge-yu-fa-fu-hao-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param N
   * @param K
   * @return
   */
  public int kthGrammar(int N, int K) {
    if (N == 1) {
      return 0;
    }
    return (~K & 1) ^ kthGrammar(N - 1, (K + 1) / 2);
  }

  /**
   * 递归 (翻转递推)
   */
  class Solution {
    /**
     * 可以通过归纳法证明以上规律，核心的思想在于，如果 XX 可以生成 YY，那么 X'X ′ 就能生成 Y'Y ′ 。 据此可以提出以下的算法： 如果 K 在第二部分，就找 K -= (1
     * << N-2) 在第一部分的答案，然后将答案翻转。
     *
     * <p>作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/k-th-symbol-in-grammar/solution/di-kge-yu-fa-fu-hao-by-leetcode/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param N
     * @param K
     * @return
     */
    public int kthGrammar(int N, int K) {
      if (N == 1) {
        return 0;
      }
      if (K <= 1 << N - 2) {
        // k在左部分
        return kthGrammar(N - 1, K);
      }
      // k在右部分
      return kthGrammar(N - 1, K - (1 << N - 2)) ^ 1;
    }
  }
}
