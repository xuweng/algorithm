package com.leetcode.tag.must.five;

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
            int max = -1;
            int i = 0;
            for (int j = low; j <= high; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                    i = j;
                }
            }
            TreeNode root = new TreeNode(max);
            root.left = dfs(nums, low, i - 1);
            root.right = dfs(nums, i + 1, high);

            return root;
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
