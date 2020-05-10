package com.leetcode.tag.daily;

/**
 * 236. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return re(root, p, q);
  }

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
  public TreeNode re(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    // 一个节点也可以是它自己的祖先
    if (root.val == p.val && root.val == q.val) {
      return root;
    }
    // 递归方程错误
    TreeNode left = re(root.left, p, q);
    TreeNode right = re(root.right, p, q);
    TreeNode node = (left == null) ? right : left;
    return (node == null) ? root : node;
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
