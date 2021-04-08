package com.leetcode.tag.must.two;

/**
 * 114. 二叉树展开为链表
 */
public class Flatten {
    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            flatten(root.left);
            flatten(root.right);

            TreeNode left = root.left;
            TreeNode right = root.right;

            root.left = null;
            root.right = left;

            TreeNode node = root;
            while (node.right != null) {
                node = node.right;
            }
            node.right = right;
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
