package com.leetcode.tag.daily.four;

/**
 * 129. 求根到叶子节点数字之和
 */
public class SumNumbers {
    class Solution {
        int result;

        public int sumNumbers(TreeNode root) {
            dfs(root, "");
            return result;
        }

        private void dfs(TreeNode root, String temp) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                result += Integer.parseInt(temp + root.val);
                return;
            }
            dfs(root.left, temp + root.val);
            dfs(root.right, temp + root.val);
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
