package com.leetcode.tag.tree.three;

/**
 * 965. 单值二叉树
 */
public class IsUnivalTree {
    class Solution {
        boolean result = true;

        public boolean isUnivalTree(TreeNode root) {
            isUnivalTree(root, root.val);

            return result;
        }

        public void isUnivalTree(TreeNode root, int val) {
            if (root == null || !result) {
                return;
            }
            if (root.val != val) {
                result = false;
            }
            isUnivalTree(root.left, val);
            isUnivalTree(root.right, val);

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
