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

    /**
     * 简洁代码
     */
    class FindElements1 {

        private TreeNode root;

        public FindElements1(TreeNode root) {
            restore(this.root = root, 0);
        }

        private void restore(TreeNode node, int index) {
            if (node != null) {
                node.val = index;
                restore(node.left, index << 1 | 1);
                restore(node.right, (index + 1) << 1);
            }
        }

        public boolean find(int target) {
            int bit;
            for (bit = 1, target++; (1 << (bit + 1)) <= target; bit++) {
            }
            TreeNode node = root;
            for (bit--; bit >= 0 && node != null; bit--) {
                // System.out.println(node.val);
                if ((target & (1 << bit)) == 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            // System.out.println(node == null ? "null" : node.val);
            // System.out.println();
            return node != null;
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
