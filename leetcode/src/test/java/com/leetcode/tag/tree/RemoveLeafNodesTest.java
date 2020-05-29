package com.leetcode.tag.tree;

import org.junit.Test;

public class RemoveLeafNodesTest {

  @Test
  public void test() {
    RemoveLeafNodes removeLeafNodes = new RemoveLeafNodes();

    RemoveLeafNodes.TreeNode root = new RemoveLeafNodes.TreeNode(1);
    RemoveLeafNodes.TreeNode left = new RemoveLeafNodes.TreeNode(1);
    RemoveLeafNodes.TreeNode right = new RemoveLeafNodes.TreeNode(1);

    root.left = left;
    root.right = right;

    int target = 1;

    removeLeafNodes.removeLeafNodes(root, target);
  }
}
