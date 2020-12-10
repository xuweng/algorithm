package com.leetcode.tag.backtracking;

import com.leetcode.tag.backtracking.one.CombinationSum;
import org.junit.Test;

public class CombinationSumTest {
  @Test
  public void replaceSpaceTest() {
    CombinationSum combinationSum = new CombinationSum();
    int[] candidates = new int[]{2, 3, 6, 7};
    int target = 7;
    combinationSum.combinationSum(candidates, target);
  }
}
