package com.leetcode.tag.tree;

/**
 * 1022. 从根到叶的二进制数之和
 * <p>
 * 树就是各种遍历。递归树。决策树。
 * <p>
 * 树就是各种遍历。递归树。决策树。
 */
public class SumRootToLeaf {
    class Solution {
        int sum;

        public int sumRootToLeaf(TreeNode root) {
            sum(root, "");

            return sum;
        }

        private void sum(TreeNode root, String temp) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                sum += Integer.parseUnsignedInt(temp + root.val, 2);
                return;
            }

            sum(root.left, temp + root.val);
            sum(root.right, temp + root.val);
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
