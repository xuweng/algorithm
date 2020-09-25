package com.leetcode.tag.tree.three;

/**
 * 671. 二叉树中第二小的节点.
 * <p>
 * 十分钟看答案.学习答案.
 */
public class FindSecondMinimumValue {
    class Solution {
        int min = 1;

        public int findSecondMinimumValue(TreeNode root) {
            pre(root);

            return min;
        }

        private void pre(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                if (root.left.val > root.val) {
                    min++;
                    pre(root.left);
                }
            }
            if (root.right != null) {
                if (root.right.val > root.val) {
                    min++;
                    pre(root.left);
                }
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
