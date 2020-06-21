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
  TreeNode root;

  public int maxPathSum(TreeNode root) {
    pre(root);

    return result;
  }

  /**
   * 先序遍历
   *
   * <p>枚举所有结点，计算每个结点的最大路径
   *
   * @param treeNode
   */
  public void pre(TreeNode treeNode) {
    if (treeNode == null) {
      return;
    }
    // 入参为0才是正确的
    root = treeNode;
    preMax(treeNode, 0);
    result = Math.max(result, max);
    max = Integer.MIN_VALUE;
    pre(treeNode.left);
    pre(treeNode.right);
  }

  /**
   * 先序遍历
   *
   * <p>先序遍历
   *
   * <p>先序遍历
   *
   * <p>累加错误
   *
   * <p>累加错误
   *
   * <p>累加错误
   *
   * <p>只考虑当前root
   *
   * <p>只考虑当前root
   *
   * <p>子问题不能简单推导原问题
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
   * <p>左+treeNode
   *
   * <p>右+treeNode
   *
   * <p>左+treeNode+右
   *
   * @param treeNode
   * @return
   */
  private void preMax(TreeNode treeNode, int sum) {
    if (treeNode == null) {
      // 入参为0，越界一定要统计
      // 这里也要统计一次
      max = Math.max(max, sum);
      return;
    }
    // 当前是root
    // 这里加上root
    max = Math.max(max, sum + treeNode.val);
    preMax(treeNode.left, sum + treeNode.val);
    if (treeNode == root) {
      // 当前结点是root
      // 左子树的结果+右子树的结果
      preMax(treeNode.right, max);
    } else {
      preMax(treeNode.right, sum + treeNode.val);
    }
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
