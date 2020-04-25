package com.leetcode.tag.recursive;

/**
 * 687. 最长同值路径
 */
public class S687 {
  /**
   * 整体思路:分治法。每个子问题都要考虑,不要遗漏任何一个子问题
   *
   * <p>小数据规模(1,2,3)验证算法正确性。只要有一个子问题计算错误,后面的计算都会错误
   *
   * <p>知道自己哪里错了,感觉最好。知道自己哪里错了。知道自己哪里做错。
   *
   * <p>通过递归想得到2个返回值?
   *
   * <p>小数据规模验证算法正确性。小数据规模。小数据规模。小数据规模。小数据规模。小数据规模。小数据规模
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
      int h = height(root);
      int s = longestUnivaluePath(root.left) + left + longestUnivaluePath(root.right) + right;
      return (h == 1) ? s : Math.min(s, h);
    }
    return Math.max(longestUnivaluePath(root.left) + left, longestUnivaluePath(root.right) + right);
  }

  /**
   * 树的高度
   *
   * <p>null----->0
   *
   * <p>叶子结点----->0
   *
   * @param root
   * @return
   */
  public int height(TreeNode root) {
    if ((root == null) || (root.left == null && root.right == null)) {
      return 0;
    }
    // 递归
    return Math.max(height(root.left), height(root.right)) + 1;
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
