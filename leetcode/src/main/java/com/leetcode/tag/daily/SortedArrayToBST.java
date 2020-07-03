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

  /**
   * 方法一：中序遍历，总是选择中间位置左边的数字作为根节点
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-33/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
      return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
      if (left > right) {
        return null;
      }

      // 总是选择中间位置左边的数字作为根节点
      int mid = (left + right) / 2;

      TreeNode root = new TreeNode(nums[mid]);
      root.left = helper(nums, left, mid - 1);
      root.right = helper(nums, mid + 1, right);
      return root;
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
