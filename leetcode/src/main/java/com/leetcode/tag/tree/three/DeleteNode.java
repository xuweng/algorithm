package com.leetcode.tag.tree.three;

/**
 * 450. 删除二叉搜索树中的节点
 * <p>
 * 3个状态.搞清楚多少个状态.
 */
public class DeleteNode {
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val == key && root.left == null && root.right == null) {
                return null;
            }
            if (root.val < key) {
                root.right = deleteNode(root.right, key);
            }
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
            }

            return root;
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
