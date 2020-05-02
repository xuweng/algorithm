package com.leetcode.tag.recursive;

/**
 * 面试题 17.12. BiNode
 */
public class s1712 {
  public TreeNode convertBiNode(TreeNode root) {
    if (root == null) {
      return null;
    }
    if (root.left == null && root.right == null) {
      return root;
    }
    TreeNode node = root;
    while (node.left != null) {
      node = node.left;
    }

    re(root);

    return node;
  }

  /**
   * 左子树最大值,右子树最小值
   *
   * <p>左右子树求值不一样
   *
   * @param root
   * @return
   */
  public void re(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      return;
    }
    // 先查询,再改变树结构
    TreeNode left = jie(root.left, true);
    TreeNode right = jie(root.right, false);
    // 左子树变成单链表
    re(root.left);
    // 右子树变成单链表
    re(root.right);
    if (left != null) {
      left.right = root;
    }
    if (right != null) {
      root.right = right;
    }
  }

  public TreeNode jie(TreeNode node, boolean isLeft) {
    if (node == null) {
      return null;
    }
    if (node.left == null && node.right == null) {
      return node;
    }
    if (isLeft) {
      return jie(node.right, isLeft);
    } else {
      return jie(node.left, isLeft);
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
