package com.leetcode.tag.tree;

/**
 * 后序遍历。后序遍历。后序遍历。后序遍历
 * <p>
 * 自顶向下。重复计算。
 * <p>
 * 自底向上。没有重复计算。
 * <p>
 * 814. 二叉树剪枝
 */
public class PruneTree {
    /**
     * 脑海里执行一遍代码
     * <p>
     * 算法错误。包含0的都干掉了。
     */
    class Solution {
        public TreeNode pruneTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode left = pruneTree(root.left);
            TreeNode right = pruneTree(root.right);
            //天然获取父节点root
            if (left != null && left.val == 0) {
                root.left = null;
            }
            if (right != null && right.val == 0) {
                root.right = null;
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
