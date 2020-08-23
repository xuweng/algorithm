package com.leetcode.tag.daily.one;

import org.junit.Test;

public class MaxPathSumTest {
  @Test
  public void test() {
    MaxPathSum.TreeNode treeNode = new MaxPathSum.TreeNode(1);
    MaxPathSum.TreeNode treeNode1 = new MaxPathSum.TreeNode(-2);
    MaxPathSum.TreeNode treeNode2 = new MaxPathSum.TreeNode(-3);
    MaxPathSum.TreeNode treeNode3 = new MaxPathSum.TreeNode(1);
    MaxPathSum.TreeNode treeNode4 = new MaxPathSum.TreeNode(3);
    MaxPathSum.TreeNode treeNode5 = new MaxPathSum.TreeNode(-2);
    MaxPathSum.TreeNode treeNode6 = new MaxPathSum.TreeNode(-1);

    treeNode.left = treeNode1;
    treeNode.right = treeNode2;

    treeNode1.left = treeNode3;
    treeNode1.right = treeNode4;

    treeNode2.left = treeNode5;

    treeNode3.left = treeNode6;

    MaxPathSum maxPathSum = new MaxPathSum();
    maxPathSum.maxPathSum(treeNode);
  }
}
