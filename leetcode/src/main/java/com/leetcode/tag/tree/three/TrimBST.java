package com.leetcode.tag.tree.three;

/**
 * 669. 修剪二叉搜索树
 * <p>
 * 简洁代码.简洁代码.简洁代码
 */
public class TrimBST {
    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }
            if (high <= root.val) {
                root.left = trimBST(root.left, low, high);
                root.right = null;
            }
            if (low >= root.val) {
                root.right = trimBST(root.right, low, high);
                root.left = null;
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
