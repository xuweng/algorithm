package com.leetcode.tag.must.one.five;

/**
 * 111. 二叉树的最小深度
 */
public class MinDepth {
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if (left == 0 || right == 0) {
                return Math.max(left, right) + 1;
            }

            return Math.min(left, right) + 1;
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
