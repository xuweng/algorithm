package com.leetcode.tag.tree.five;

/**
 * 563. 二叉树的坡度
 */
public class FindTilt {
    class Solution {
        int result;

        public int findTilt(TreeNode root) {
            return root == null ? 0 : Math.abs(dfs(root.left) - dfs(root.right)) + result;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            result += Math.abs(left - right);

            return left + right + root.val;
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
