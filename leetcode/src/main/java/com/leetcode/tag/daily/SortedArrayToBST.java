package com.leetcode.tag.daily;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {
  public TreeNode sortedArrayToBST(int[] nums) {
    return buildTree(nums, 0, nums.length - 1);
  }

  /**
   * 小规模数据调试
   *
   * <p>小规模数据调试
   *
   * <p>小规模数据调试
   *
   * @param nums
   * @param start
   * @param end
   * @return
   */
  public TreeNode buildTree(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }
    int root = (start + end) / 2;

    TreeNode rootNode = new TreeNode(nums[root]);
    rootNode.left = buildTree(nums, start, root - 1);
    rootNode.right = buildTree(nums, root + 1, end);

    return rootNode;
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
