package com.leetcode.tag.tree.three;

/**
 * 543. 二叉树的直径
 */
public class DiameterOfBinaryTree {
    /**
     * 算法错误
     */
    class Solution {
        int max;

        public int diameterOfBinaryTree(TreeNode root) {
            diameterOfBinaryTree1(root);

            return max - 1;
        }

        public int diameterOfBinaryTree1(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int result = diameterOfBinaryTree1(root.left) + diameterOfBinaryTree1(root.right) + 1;
            max = Math.max(max, result);
            return result;
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
