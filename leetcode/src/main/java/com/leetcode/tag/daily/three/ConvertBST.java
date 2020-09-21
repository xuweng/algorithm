package com.leetcode.tag.daily.three;

/**
 * 538. 把二叉搜索树转换为累加树
 */
public class ConvertBST {
    class Solution {
        int sum;
        TreeNode root;

        public TreeNode convertBST(TreeNode root) {
            this.root = root;

            pre(root);

            return root;
        }

        private void pre(TreeNode root) {
            if (root == null) {
                return;
            }
            pre(this.root, root.val);
            root.val += sum;
            sum = 0;
            pre(root.left);
            pre(root.right);
        }

        /**
         * 每次都是遍历原来的tree,会修改原来tree的值
         *
         * @param root
         * @param val
         */
        private void pre(TreeNode root, int val) {
            if (root == null) {
                return;
            }
            if (root.val > val) {
                sum += root.val;
            }
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
