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
            path(root, sum);

            myPathSum(root.left, sum);
            myPathSum(root.right, sum);
        }

        private void path(TreeNode root, int sum) {
            //考虑负数
            if (root == null || root.val > sum) {
                return;
            }
            if (root.val == sum) {
                result++;
                return;
            }
            path(root.left, sum - root.val);
            path(root.right, sum - root.val);
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
