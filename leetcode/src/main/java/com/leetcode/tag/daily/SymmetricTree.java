package com.leetcode.tag.daily;

public class SymmetricTree {
  /**
   * 假设求左子树是否对称，求右子树是否对称。没什么用。
   *
   * <p>左子树，右子树两个子问题。先搞定左子树，然后搞定右子树。
   *
   * <p>同时依赖左子树和右子树。子问题依赖。子问题不独立。
   *
   * @param root
   * @return
   */
  public TreeNode isSymmetric(TreeNode root) {

    TreeNode left = isSymmetric(root.left);
    TreeNode right = isSymmetric(root.right);

    return null;
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
