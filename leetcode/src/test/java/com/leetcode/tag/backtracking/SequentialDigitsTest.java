package com.leetcode.tag.backtracking;

import com.leetcode.tag.backtracking.one.SequentialDigits;
import org.junit.Test;

public class SequentialDigitsTest {

  @Test
  public void test() {
    SequentialDigits sequentialDigits = new SequentialDigits();

    int low = 100;
    int high = 300;
    sequentialDigits.sequentialDigits(low, high);
  }
}
