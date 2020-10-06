package com.leetcode.tag.dfs.one;

/**
 * 897. 递增顺序查找树
 */
public class IncreasingBST {
    class Solution {
        TreeNode pre;
        TreeNode root;

        public TreeNode increasingBST(TreeNode root) {
            inorder(root);

            return this.root;
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);

            if (pre == null) {
                this.root = root;
            } else {
                pre.right = root;
            }
            pre = root;
            root.left = null;

            inorder(root.right);
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
