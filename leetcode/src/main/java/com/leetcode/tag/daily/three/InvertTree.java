package com.leetcode.tag.daily.three;

/**
 * 226. 翻转二叉树
 */
public class InvertTree {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            return invert(root, root);
        }

        /**
         * 都是一颗tree
         * <p>
         * 这样会改变tree的数据,导致后面的赋值错误
         *
         * @param root
         * @param root1
         */
        private TreeNode invert(TreeNode root, TreeNode root1) {
            if (root == null) {
                return null;
            }
            TreeNode treeNode = new TreeNode(root1.val);
            treeNode.left = invert(root.left, root1.right);
            treeNode.right = invert(root.right, root1.left);

            return treeNode;
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
