package com.leetcode.tag.tree.seven;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
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

            return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
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
