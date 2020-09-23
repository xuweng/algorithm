package com.leetcode.tag.tree.three;

/**
 * 1315. 祖父节点值为偶数的节点和
 * <p>
 * 3个状态.反序遍历
 */
public class SumEvenGrandparent {
    class Solution {
        int sum;

        public int sumEvenGrandparent(TreeNode root) {
            sum(root);

            return sum;
        }

        private void sum(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.val % 2 == 0) {
                pre(root);
            }
            sum(root.left);
            sum(root.right);

        }

        private void pre(TreeNode root) {
            if (root == null || root.val % 2 != 0) {
                return;
            }
            mySum(root.left);
            mySum(root.right);
        }

        private void mySum(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                sum += root.left.val;
            }
            if (root.right != null) {
                sum += root.right.val;
            }
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
