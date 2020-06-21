package com.leetcode.tag.daily;

/**
 * 搞懂题目
 *
 * <p>搞懂示例
 *
 * <p>搞懂题目
 *
 * <p>搞懂示例
 *
 * <p>遍历。穷举。遍历。穷举。遍历。穷举。遍历。穷举。遍历。穷举。穷举。遍历。遍历。穷举。
 *
 * <p>124. 二叉树中的最大路径和
 */
public class MaxPathSum {
  private long max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    pre(root);

    return (int) max;
  }

  public void pre(TreeNode root) {
    if (root == null) {
      return;
    }
    max = Math.max(max, max(root));
    maxPathSum(root.left);
    maxPathSum(root.right);
  }

  private long max(TreeNode root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }
    long left = max(root.left);
    long right = max(root.right);
    long max = Math.max(root.val, Math.max(left, right));
    max = Math.max(max, left + root.val);
    max = Math.max(max, right + root.val);
    max = Math.max(max, left + root.val + right);

    return max;
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
