package com.leetcode.tag.must.three;

/**
 * 654. 最大二叉树
 */
public class ConstructMaximumBinaryTree {
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }

            return dfs(nums, 0, nums.length - 1);
        }

        private TreeNode dfs(int[] nums, int low, int high) {
            if (low > high) {
                return null;
            }
            int max = Integer.MIN_VALUE;
            int root = 0;
            for (int i = low; i <= high; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    root = i;
                }
            }
            TreeNode node = new TreeNode(max);
            node.left = dfs(nums, low, root - 1);
            node.right = dfs(nums, root + 1, high);

            return node;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
