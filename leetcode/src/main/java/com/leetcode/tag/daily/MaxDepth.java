package com.leetcode.tag.daily;

/**
 * 104. 二叉树的最大深度
 */
public class MaxDepth {
  class Solution {
    int result;

    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      pre(root, 1);

      return result;
    }

    public void pre(TreeNode root, int count) {
      if (root == null) {
        return;
      }
      if (root.left == null && root.right == null) {
        result = Math.max(result, count);
        return;
      }
      pre(root.left, count + 1);
      pre(root.right, count + 1);
    }
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
