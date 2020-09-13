package com.leetcode.tag.tree.two;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 */
public class MaxDepth {
    class Solution {
        public int maxDepth(TreeNode root) {
            return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
