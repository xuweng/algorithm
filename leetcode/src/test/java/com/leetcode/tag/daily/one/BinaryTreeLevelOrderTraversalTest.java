package com.leetcode.tag.daily.one;

import org.junit.Test;

public class BinaryTreeLevelOrderTraversalTest {
  @Test
  public void test() {
    BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal =
            new BinaryTreeLevelOrderTraversal();
    BinaryTreeLevelOrderTraversal.TreeNode root = new BinaryTreeLevelOrderTraversal.TreeNode(3);
    BinaryTreeLevelOrderTraversal.TreeNode n1 = new BinaryTreeLevelOrderTraversal.TreeNode(9);
    BinaryTreeLevelOrderTraversal.TreeNode n2 = new BinaryTreeLevelOrderTraversal.TreeNode(20);
    BinaryTreeLevelOrderTraversal.TreeNode n3 = new BinaryTreeLevelOrderTraversal.TreeNode(15);
    BinaryTreeLevelOrderTraversal.TreeNode n4 = new BinaryTreeLevelOrderTraversal.TreeNode(7);

    root.left = n1;
    root.right = n2;

    n1.left = null;
    n1.right = null;

    n2.left = n3;
    n2.right = n4;

    n3.left = null;
    n3.right = null;

    n4.left = null;
    n4.right = null;
    binaryTreeLevelOrderTraversal.levelOrder(root);
  }
}
