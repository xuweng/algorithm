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
  private int result = Integer.MIN_VALUE;
  private int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    pre(root);

    return (int) result;
  }

  public void pre(TreeNode root) {
    if (root == null) {
      return;
    }
    preMax(root, 0);
    result = Math.max(result, max);
    max = Integer.MIN_VALUE;
    maxPathSum(root.left);
    maxPathSum(root.right);
  }

  /**
   * 子问题不能简单推导原问题
   *
   * <p>从root出发遍历每条路径
   *
   * <p>经过root结点
   *
   * <p>用子问题推导原问题
   *
   * <p>4个子问题?
   *
   * <p>单个root
   *
   * <p>左+root
   *
   * <p>右+root
   *
   * <p>左+root+右
   *
   * @param root
   * @return
   */
  private void preMax(TreeNode root, int sum) {
    if (root == null) {
      return;
    }
    max = Math.max(max, sum);
    preMax(root.left, sum + root.val);
    // 左子树的结果+右子树的结果
    preMax(root.right, sum);
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
