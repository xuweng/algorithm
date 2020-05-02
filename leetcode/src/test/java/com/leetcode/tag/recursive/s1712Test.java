package com.leetcode.tag.recursive;

import org.junit.Test;

public class s1712Test {
  @Test
  public void replaceSpaceTest() {
    int[][] array = {{1, 1}};
    s1712 s1712 = new s1712();

    com.leetcode.tag.recursive.s1712.TreeNode root = new com.leetcode.tag.recursive.s1712.TreeNode(2);
    com.leetcode.tag.recursive.s1712.TreeNode l = new com.leetcode.tag.recursive.s1712.TreeNode(1);
    com.leetcode.tag.recursive.s1712.TreeNode r = new com.leetcode.tag.recursive.s1712.TreeNode(3);

    root.left = l;
    root.right = r;

    s1712.convertBiNode(root);
  }
}
