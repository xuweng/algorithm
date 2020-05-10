package com.leetcode.tag.daily;

/**
 * 236. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {
  /**
   * 递归方程错误
   *
   * <p>左,root,右
   *
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // 递归终止条件
    // 一个节点也可以是它自己的祖先
    if (root == null || root.val == p.val || root.val == q.val) {
      return root;
    }
    // 相等肯定是root,不等也可以是root
    // 递归方程错误
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) {
      return root;
    }
    return left == null ? right : left;
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
