package com.leetcode.tag.tree.two;

/**
 * 701. 二叉搜索树中的插入操作
 * <p>
 * bst天然剪枝.天然剪枝.天然剪枝
 */
public class InsertIntoBST {
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (val <= root.val) {
                root.left = insertIntoBST(root.left, val);
            } else {
                root.right = insertIntoBST(root.right, val);
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
