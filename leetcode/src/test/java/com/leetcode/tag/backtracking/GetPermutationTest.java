package com.leetcode.tag.backtracking;

import com.leetcode.tag.backtracking.one.GetPermutation;
import org.junit.Test;

public class GetPermutationTest {

  @Test
  public void test() {
    GetPermutation getPermutation = new GetPermutation();

    int n = 3;
    int k = 3;
    getPermutation.getPermutation(n, k);
  }
}
