package com.leetcode.tag.must.one.one;

/**
 * 226. 翻转二叉树
 * <p>
 * 正序遍历 倒序遍历
 */
public class InvertTree {
    /**
     * 后序遍历
     */
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);

            root.left = right;
            root.right = left;
            return root;
        }
    }

    /**
     * 先序遍历
     */
    class Solution1 {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertTree(root.left);
            invertTree(root.right);

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
