package com.leetcode.tag.divide;

import org.junit.Test;

public class TreeToDoublyListTest {
  @Test
  public void test() {
    TreeToDoublyList treeToDoublyList = new TreeToDoublyList();

    TreeToDoublyList.Node root = new TreeToDoublyList.Node();
    TreeToDoublyList.Node left = new TreeToDoublyList.Node();

    root.right = null;
    root.val = 4;
    root.left = left;

    left.left = null;
    left.right = null;
    left.val = 2;

    System.out.println(treeToDoublyList.treeToDoublyList(root));
  }
}
