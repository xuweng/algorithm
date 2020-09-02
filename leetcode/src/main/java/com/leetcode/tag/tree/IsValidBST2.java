package com.leetcode.tag.tree;

/**
 * 面试题 04.05. 合法二叉搜索树
 * <p>
 * 适当放弃。不纠结。
 * <p>
 * 适当放弃。不纠结。
 * <p>
 * 自己写一遍。自己写一遍。自己写一遍。
 */
public class IsValidBST2 {
    /**
     * 自己写一遍
     * <p>
     * 大数越界。
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isValidBST(root.left, Integer.MIN_VALUE, root.val) && isValidBST(root.right, root.val, Integer.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode root, int min, int max) {
            if (root == null) {
                return true;
            }
            if (root.val <= min || root.val >= max) {
                return false;
            }
            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
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
