package com.leetcode.tag.daily;

import org.junit.Test;

public class RecoverFromPreorderTest {
  @Test
  public void test() {
    RecoverFromPreorder.Solution recoverFromPreorder = new RecoverFromPreorder.Solution();

    //    String S = "1-2--3--4-5--6--7";
    //    String S = "1-2--3---4-5--6---7";
    // 这个测试用例有问题
    // 单个字符数字可以。多个字符数字不可以。
    String S = "1-401--349---90--88";
    RecoverFromPreorder.TreeNode treeNode = recoverFromPreorder.recoverFromPreorder(S);

    System.out.println();
  }
}
