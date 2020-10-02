package com.leetcode.tag.tree.six;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            return erFen(nums, 0, nums.length - 1);
        }

        private TreeNode erFen(int[] nums, int low, int high) {
            if (low > high) {
                return null;
            }
            int mid = low + (high - low) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = erFen(nums, low, mid - 1);
            root.right = erFen(nums, mid + 1, high);
            return root;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
