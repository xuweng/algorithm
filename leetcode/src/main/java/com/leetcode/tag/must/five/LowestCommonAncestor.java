package com.leetcode.tag.must.five;

/**
 * 236. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left == null) {
                return lowestCommonAncestor(root.right, p, q);
            }
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right == null) {
                return left;
            }

            return root;
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
