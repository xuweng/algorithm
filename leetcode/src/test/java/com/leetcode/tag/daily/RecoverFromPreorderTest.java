package com.leetcode.tag.daily;

import org.junit.Test;

public class RecoverFromPreorderTest {
  @Test
  public void test() {
    RecoverFromPreorder.Solution recoverFromPreorder = new RecoverFromPreorder.Solution();

    String S = "1-2--3--4-5--6--7";
    recoverFromPreorder.recoverFromPreorder(S);
  }
}
