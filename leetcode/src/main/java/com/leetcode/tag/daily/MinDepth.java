package com.leetcode.tag.daily;

/**
 * 111. 二叉树的最小深度
 */
public class MinDepth {
    class Solution {
        int result = Integer.MAX_VALUE;

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            pre(root, 1);
            return result;
        }

        public void pre(TreeNode treeNode, int count) {
            if (treeNode == null) {
                return;
            }
            if (treeNode.left == null && treeNode.right == null) {
                result = Math.min(result, count);
            }
            pre(treeNode.left, ++count);
            pre(treeNode.right, ++count);
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
