package com.leetcode.tag.must.three;

/**
 * 98. 验证二叉搜索树
 */
public class IsValidBST {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean dfs(TreeNode root, long minValue, long maxValue) {
            if (root == null) {
                return true;
            }
            if (root.val <= minValue || root.val >= maxValue) {
                return false;
            }

            return dfs(root.left, minValue, root.val) && dfs(root.right, root.val, maxValue);
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
