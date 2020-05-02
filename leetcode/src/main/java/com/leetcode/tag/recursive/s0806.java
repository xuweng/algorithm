package com.leetcode.tag.recursive;

import java.util.List;

/**
 * 面试题 08.06. 汉诺塔问题
 */
public class s0806 {
  public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
    re(A, B, C, A.size());
  }

  /**
   * n = 1 时，直接把盘子从 A 移到 C；
   *
   * <p>n > 1 时， 先把上面 n - 1 个盘子从 A 移到 B（子问题，递归）；
   *
   * <p>再将最大的盘子从 A 移到 C； 再将 B 上 n - 1 个盘子从 B 移到 C（子问题，递归）。
   *
   * <p>作者：z1m
   * 链接：https://leetcode-cn.com/problems/hanota-lcci/solution/tu-jie-yi-nuo-ta-de-gu-shi-ju-shuo-dang-64ge-pan-z/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param A
   * @param B
   * @param C
   * @param n
   */
  public void re(List<Integer> A, List<Integer> B, List<Integer> C, int n) {
    if (n <= 0) {
      return;
    }
    // 终止条件
    if (n == 1) {
      C.add(A.remove(A.size() - 1));
      return;
    }
    re(A, C, B, n - 1);
    C.add(A.remove(A.size() - 1));
    re(B, A, C, n - 1);
  }
}
