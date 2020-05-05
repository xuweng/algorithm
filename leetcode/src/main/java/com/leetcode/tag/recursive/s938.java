package com.leetcode.tag.recursive;

/**
 * 938. 二叉搜索树的范围和
 */
public class s938 {
  int sum;

  public int rangeSumBST(TreeNode root, int L, int R) {
    if (root == null) {
      return 0;
    }
    rangeSumBST(root.left, L, R);
    if (root.val >= L && root.val <= R) {
      sum += root.val;
    }
    rangeSumBST(root.right, L, R);
    return sum;
  }

  /**
   * 整体思路正确就,修修补补
   *
   * <p>小数据规模验证
   *
   * @param root
   * @param L
   * @param R
   * @return
   */
  public int re(TreeNode root, int L, int R) {
    if (root == null) {
      return 0;
    }
    if (R < root.val) {
      return re(root.left, L, R);
    }
    if (R == root.val) {
      return re(root.left, L, R) + root.val;
    }
    if (L == root.val) {
      return re(root.right, L, R) + root.val;
    }
    if (L > root.val) {
      return re(root.right, L, R);
    }
    return re(root.left, L, R) + re(root.right, L, R) + root.val;
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
