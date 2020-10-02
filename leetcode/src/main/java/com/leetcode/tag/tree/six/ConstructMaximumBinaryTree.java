package com.leetcode.tag.tree.six;

/**
 * 654. 最大二叉树
 */
public class ConstructMaximumBinaryTree {
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            return constructMaximumBinaryTree(nums, 0, nums.length - 1);
        }

        public TreeNode constructMaximumBinaryTree(int[] nums, int low, int high) {
            if (low > high) {
                return null;
            }
            int rootIndex = getMax(nums, low, high);
            TreeNode root = new TreeNode(nums[rootIndex]);
            root.left = constructMaximumBinaryTree(nums, low, rootIndex - 1);
            root.right = constructMaximumBinaryTree(nums, rootIndex + 1, high);
            return root;
        }

        private int getMax(int[] nums, int low, int high) {
            int max = Integer.MIN_VALUE;
            int result = 0;
            for (int i = low; i <= high; i++) {
                if (nums[i] > max) {
                    result = i;
                    max = nums[i];
                }
            }
            return result;
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
