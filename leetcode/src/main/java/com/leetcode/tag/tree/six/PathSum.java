package com.leetcode.tag.tree.six;

/**
 * 437. 路径总和 III
 */
public class PathSum {
    class Solution {
        int result;

        public int pathSum(TreeNode root, int sum) {
            pre(root, sum);

            return result;
        }

        private void pre(TreeNode root, int sum) {
            if (root == null) {
                return;
            }
            pre1(root, sum);
            pre(root.left, sum);
            pre(root.right, sum);
        }

        private void pre1(TreeNode root, int sum) {
            if (root == null) {
                return;
            }
            if (sum == root.val) {
                result++;
            }
            pre1(root.left, sum - root.val);
            pre1(root.right, sum - root.val);
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
