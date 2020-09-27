package com.leetcode.tag.tree.three;

/**
 * 面试题 04.02. 最小高度树
 */
public class SortedArrayToBST {
    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }

        public TreeNode sortedArrayToBST(int[] nums, int low, int high) {
            //此条件必须
            if (low > high) {
                return null;
            }
            if (low == high) {
                return new TreeNode(nums[low]);
            }
            int mid = low + (high - low) / 2;

            TreeNode root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(nums, low, mid - 1);
            root.right = sortedArrayToBST(nums, mid + 1, high);

            return root;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
