package com.leetcode.tag.must.one;

/**
 * 226. 翻转二叉树
 * <p>
 * 正序遍历 倒序遍历
 */
public class InvertTree {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            root.right = invertTree(root.left);
            root.left = invertTree(root.right);

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
