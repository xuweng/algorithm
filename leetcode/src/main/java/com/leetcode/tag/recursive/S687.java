package com.leetcode.tag.recursive;

/**
 * 687. 最长同值路径
 */
public class S687 {
  /**
   * 整体思路:分治法。每个子问题都要考虑,不要遗漏任何一个子问题
   *
   * <p>小数据规模(1,2,3)验证算法正确性
   *
   * <p>left,right,root-left,root-right,left-root-right;
   *
   * <p>确定问题;所有解法;coding;test
   *
   * @param root
   * @return
   */
  public int longestUnivaluePath(TreeNode root) {
    if ((root == null) || (root.left == null) && root.right == null) {
      return 0;
    }
    // root-left
    int left = (root.left != null && root.val == root.left.val) ? 1 : 0;
    // root-right
    int right = (root.right != null && root.val == root.right.val) ? 1 : 0;
    if (left == right && left == 1) {
      // left-root-right
      return longestUnivaluePath(root.left) + left + longestUnivaluePath(root.right) + right;
    }
    return Math.max(longestUnivaluePath(root.left) + left, longestUnivaluePath(root.right) + right);
  }

  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
