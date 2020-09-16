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
    /**
     * 超出时间限制
     */
    class Solution {
        int result;

        public int longestZigZag(TreeNode root) {
            pre(root);

            //减掉null结点
            return result - 1;
        }

        private void pre(TreeNode root) {
            if (root == null) {
                return;
            }
            pre(root, true, 0);
            pre(root, false, 0);

            pre(root.left);
            pre(root.right);
        }

        /**
         * 算法错误
         *
         * @param root
         * @param isLeft
         * @param count
         */
        private void pre(TreeNode root, boolean isLeft, int count) {
            //是这里统计
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
