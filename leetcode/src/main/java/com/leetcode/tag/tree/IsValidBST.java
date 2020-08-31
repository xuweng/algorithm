package com.leetcode.tag.tree;

/**
 * 面试题 04.05. 合法二叉搜索树
 */
public class IsValidBST {
    /**
     * 算法错误
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null || root.left == null && root.right == null) {
                return true;
            }
            boolean left = isValidBST(root.left);
            boolean right = isValidBST(root.right);

            //算法错误
            //不能只比较一个结点
            return (root.left.val < root.val && root.val > root.right.val) && left && right;
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
