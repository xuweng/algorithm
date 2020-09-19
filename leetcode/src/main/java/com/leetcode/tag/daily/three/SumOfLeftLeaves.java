package com.leetcode.tag.daily.three;

/**
 * 404. 左叶子之和
 */
public class SumOfLeftLeaves {
    class Solution {
        int result;

        public int sumOfLeftLeaves(TreeNode root) {
            pre(root, true);

            return result;
        }

        public void pre(TreeNode root, boolean isLeft) {
            if (root == null) {
                return;
            }
            if (isLeft && root.left == null && root.right == null) {
                result += root.val;
            }
            pre(root.left, true);
            pre(root.right, false);
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
