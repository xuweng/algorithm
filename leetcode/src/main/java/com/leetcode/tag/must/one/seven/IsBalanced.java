package com.leetcode.tag.must.one.seven;

/**
 * 110. 平衡二叉树
 */
public class IsBalanced {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return dfs(root) != -1;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            if (left == -1) {
                return -1;
            }
            int right = dfs(root.right);
            if (right == -1) {
                return -1;
            }

            return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
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
