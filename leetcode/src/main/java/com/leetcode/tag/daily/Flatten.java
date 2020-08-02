package com.leetcode.tag.daily;

/**
 * 114. 二叉树展开为链表
 */
public class Flatten {
    /**
     * 算法是一种思维。代表一个人的思考。
     */
    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            re(root);
        }

        private TreeNode re(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode node = leftRight(root.left);
            root.right = re(root.left);
            if (node != null) {
                node.right = re(root.right);
            }
            return root;
        }

        private TreeNode leftRight(TreeNode root) {
            if (root == null) {
                return null;
            }
            if (root.right == null) {
                return root;
            }
            return leftRight(root.right);
        }
    }

    public class TreeNode {
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

