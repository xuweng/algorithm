package com.leetcode.tag.dfs.three;

/**
 * 337. 打家劫舍 III
 */
public class Rob2 {
    class Solution {
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int[] result = dfs(root);
            return Math.max(result[0], result[1]);
        }

        private int[] dfs(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);

            int select = root.val + left[1] + right[1];
            int notSelect = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

            return new int[]{select, notSelect};
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
