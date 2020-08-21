package com.leetcode.tag.daily;

/**
 * 111. 二叉树的最小深度
 */
public class MinDepth {
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
