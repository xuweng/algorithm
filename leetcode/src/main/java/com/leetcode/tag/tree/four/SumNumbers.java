package com.leetcode.tag.tree.four;

/**
 * 129. 求根到叶子节点数字之和
 */
public class SumNumbers {
    class Solution {
        int result;

        public int sumNumbers(TreeNode root) {
            pre(root, "");

            return result;
        }

        private void pre(TreeNode root, String temp) {
            if (root == null) {
                result += Integer.parseInt(temp);
                return;
            }
            pre(root.left, temp + root.val);
            pre(root.right, temp + root.val);
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
