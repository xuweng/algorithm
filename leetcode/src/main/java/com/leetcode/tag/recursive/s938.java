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

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
