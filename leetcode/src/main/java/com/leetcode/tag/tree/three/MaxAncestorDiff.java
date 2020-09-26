package com.leetcode.tag.tree.three;

/**
 * 1026. 节点与其祖先之间的最大差值
 */
public class MaxAncestorDiff {
    class Solution {
        int max;
        int result;

        public int maxAncestorDiff(TreeNode root) {
            pre(root);

            return result;
        }

        private void pre(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                pre(root.left, root.val);
                result = Math.max(result, max);
                max = 0;
            }
            if (root.right != null) {
                pre(root.right, root.val);
                result = Math.max(result, max);
                max = 0;
            }

            pre(root.left);
            pre(root.right);
        }

        private void pre(TreeNode root, int val) {
            if (root == null) {
                return;
            }
            max = Math.max(max, Math.abs(val - root.val));
            pre(root.left, val);
            pre(root.right, val);
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
