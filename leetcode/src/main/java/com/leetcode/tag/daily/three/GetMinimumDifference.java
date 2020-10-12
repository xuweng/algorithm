package com.leetcode.tag.daily.three;

/**
 * 530. 二叉搜索树的最小绝对差
 */
public class GetMinimumDifference {
    class Solution {
        int result;
        TreeNode pre;

        public int getMinimumDifference(TreeNode root) {
            inorder(root);

            return result;
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);

            if (pre != null) {
                result = Math.min(result, root.val - pre.val);
            }
            pre = root;

            inorder(root.right);
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
