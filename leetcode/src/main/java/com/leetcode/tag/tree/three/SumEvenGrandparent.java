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
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left != null) {
                if (left.left != null) {
                    sum += left.left.val;
                }
                if (left.right != null) {
                    sum += left.right.val;
                }
                pre(left.left);
                pre(left.right);
            }
            if (right != null) {
                if (right.right != null) {
                    sum += right.left.val;
                }
                if (right.right != null) {
                    sum += right.right.val;
                }
                pre(right.left);
                pre(right.right);
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
