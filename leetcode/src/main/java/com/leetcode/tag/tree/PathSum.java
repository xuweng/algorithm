package com.leetcode.tag.tree;

/**
 * 面试题 04.12. 求和路径
 */
public class PathSum {
    class Solution {
        int result;

        public int pathSum(TreeNode root, int sum) {
            myPathSum(root, sum);

            return result;
        }

        /**
         * 先序遍历
         *
         * @param root
         * @param sum
         */
        public void myPathSum(TreeNode root, int sum) {
            if (root == null) {
                return;
            }
            if (path(root, sum)) {
                result++;
            }
            myPathSum(root.left, sum);
            myPathSum(root.right, sum);
        }

        private boolean path(TreeNode root, int sum) {
            if (root == null || root.val > sum) {
                return false;
            }
            if (root.val == sum) {
                return true;
            }
            return path(root.left, sum - root.val) || path(root.right, sum - root.val);
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
