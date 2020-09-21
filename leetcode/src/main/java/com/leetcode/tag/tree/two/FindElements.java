package com.leetcode.tag.tree.two;

/**
 * 1261. 在受污染的二叉树中查找元素
 */
public class FindElements {
    TreeNode root;

    public FindElements(TreeNode root) {
        this.root = root;
        this.root.val = 0;

        recover(this.root);
    }

    private void recover(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.val = 2 * root.val + 1;
            recover(root.left);
        }
        if (root.right != null) {
            root.right.val = 2 * root.val + 2;
            recover(root.right);
        }
    }

    public boolean find(int target) {
        return find(this.root, target);
    }

    public boolean find(TreeNode treeNode, int target) {
        if (treeNode == null) {
            return false;
        }
        if (treeNode.val == target) {
            return true;
        }
        if (find(treeNode.left, target)) {
            return true;
        }
        if (find(treeNode.right, target)) {
            return true;
        }
        return false;
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
