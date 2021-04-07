package com.leetcode.tag.must.ten;

/**
 * 337. 打家劫舍 III
 */
public class Rob1 {
    class Solution {
        public int rob(TreeNode root) {
            int[] ints = myRob(root);

            return Math.max(ints[0], ints[1]);
        }

        private int[] myRob(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }
            int[] left = myRob(root.left);
            int[] right = myRob(root.right);

            int[] dp = new int[2];
            dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            dp[1] = left[0] + right[0] + root.val;

            return dp;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
