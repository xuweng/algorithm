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
  private int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    pre(root);

    return max;
  }

  public void pre(TreeNode root) {
    if (root == null) {
      return;
    }
    max = Math.max(max, max(root));
    maxPathSum(root.left);
    maxPathSum(root.right);
  }

  private int max(TreeNode root) {
    if (root == null) {
      return 0;
    }
    // 叶子结点
    if (root.left == null && root.right == null) {
      return root.val;
    }
    int left = max(root.left);
    int right = max(root.right);
    int max = Math.max(left, right);
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
