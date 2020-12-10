package com.leetcode.tag.backtracking;

import com.leetcode.tag.backtracking.one.IsAdditiveNumber;
import org.junit.Assert;
import org.junit.Test;

public class IsAdditiveNumberTest {
  IsAdditiveNumber isAdditiveNumber = new IsAdditiveNumber();

  @Test
  public void test() {
    String num = "112358";
    Assert.assertTrue(isAdditiveNumber.isAdditiveNumber(num));
  }

  @Test
  public void test1() {
    String num = "199100199";
    Assert.assertTrue(isAdditiveNumber.isAdditiveNumber(num));
  }
}
