package com.leetcode.tag.recursive;

import java.util.List;

/**
 * 面试题 08.06. 汉诺塔问题
 */
public class s0806 {
  public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
    re(A, B, C, A.size());
  }

  public void re(List<Integer> A, List<Integer> B, List<Integer> C, int n) {
    if (n <= 0) {
      return;
    }
    // 终止条件
    if (n == 1) {
      C.add(A.get(0));
      return;
    }
    re(A, C, B, n - 1);
    C.add(A.get(0));
    A.clear();
    re(B, A, C, n - 1);
  }
}
