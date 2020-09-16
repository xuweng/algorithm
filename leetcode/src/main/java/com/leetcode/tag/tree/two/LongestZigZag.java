package com.leetcode.tag.tree.two;

/**
 * 1372. 二叉树中的最长交错路径
 * <p>
 * 用一个栈就可以完成遍历,不用cur
 * <p>
 * 用一个栈。不用cur。
 * <p>
 * 虽然简单,就是想不出来
 */
public class LongestZigZag {
    class Solution {
        int result;
        int result2;

        public int longestZigZag(TreeNode root) {
            return result;
        }

        private void pre(TreeNode root) {
            if (root == null) {
                return;
            }
            result = 0;
            pre(root, true, 0);
            result2 = Math.max(result2, result);
            result = 0;
            pre(root, false, 0);
            result2 = Math.max(result2, result);

            pre(root.left);
            pre(root.right);
        }

        private void pre(TreeNode root, boolean isLeft, int count) {
            if (root == null) {
                result = Math.max(result, count);
                return;
            }
            if (isLeft) {
                pre(root.right, false, count + 1);
            } else {
                pre(root.left, true, count + 1);
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
