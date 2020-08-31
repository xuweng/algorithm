package com.leetcode.tag.tree;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 * <p>
 * 不用做晦涩题目。直接看题解。
 * <p>
 * 任意节点的左右子树的深度相差不超过1
 * <p>
 * 任意结点。递归定义。
 */
public class IsBalanced {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return root == null || Math.abs(height(root.left) - height(root.right)) <= 1;
        }

        private int height(TreeNode root) {
            return root == null ? 0 : Math.max(height(root.left), height(root.right)) + 1;
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
