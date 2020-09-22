package com.leetcode.tag.tree.three;

/**
 * 965. 单值二叉树
 */
public class IsUnivalTree {
    class Solution {
        public boolean isUnivalTree(TreeNode root) {
            return root == null || isUnivalTree(root, root.val);
        }

        public boolean isUnivalTree(TreeNode root, int val) {
            if (root == null) {
                return true;
            }
            if (root.val != val) {
                return false;
            }
            if (isUnivalTree(root.left, val)) {
                return true;
            }
            return isUnivalTree(root.right, val);

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
