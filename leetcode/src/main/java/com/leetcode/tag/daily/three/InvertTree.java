package com.leetcode.tag.daily.three;

/**
 * 226. 翻转二叉树
 */
public class InvertTree {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            invert(root, root);

            return root;
        }

        private void invert(TreeNode root, TreeNode root1) {
            if (root == null) {
                return;
            }
            root.val = root1.val;
            invert(root.left, root1.right);
            invert(root.right, root1.left);
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
