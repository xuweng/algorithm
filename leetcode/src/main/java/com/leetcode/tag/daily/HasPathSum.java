package com.leetcode.tag.daily;

/**
 * 112. 路径总和
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 */
public class HasPathSum {
  /**
   * 根节点到叶子节点的路径
   *
   * @param root
   * @param sum
   * @return
   */
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    return re(root, sum);
  }

  public boolean re(TreeNode root, int sum) {
    if (root == null) {
      return sum == 0;
    }
    if (root.left == null && root.right == null) {
      return root.val == sum;
    }
    if (root.left != null && root.right == null) {
      return re(root.left, sum - root.val);
    }
    if (root.left == null) {
      return re(root.right, sum - root.val);
    }

    return re(root.left, sum - root.val) || re(root.right, sum - root.val);
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
