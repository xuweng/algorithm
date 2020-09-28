package com.leetcode.tag.tree.four;

/**
 * 面试题 04.04. 检查平衡性
 */
public class IsBalanced {
    class Solution {
        boolean result = true;

        public boolean isBalanced(TreeNode root) {
            height(root);

            return result;
        }

        private int height(TreeNode root) {
            if (root == null || !result) {
                return 0;
            }
            int left = height(root.left);
            int right = height(root.right);
            if (Math.abs(left - right) > 1) {
                result = false;
            }
            return Math.max(left, right) + 1;
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
