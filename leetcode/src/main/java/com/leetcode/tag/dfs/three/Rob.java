package com.leetcode.tag.dfs.three;

/**
 * 337. 打家劫舍 III
 */
public class Rob {
    class Solution {
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = 0;
            int right = 0;
            int cur = root.val;
            if (root.left != null) {
                left = rob(root.left);
                cur += rob(root.left.left);
                cur += rob(root.left.right);
            }
            if (root.right != null) {
                right = rob(root.right);
                cur += rob(root.right.left);
                cur += rob(root.right.right);
            }

            return Math.max(cur, left + right);
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
