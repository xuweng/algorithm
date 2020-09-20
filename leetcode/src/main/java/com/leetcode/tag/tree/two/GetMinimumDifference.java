package com.leetcode.tag.tree.two;

/**
 * 530. 二叉搜索树的最小绝对差
 * <p>
 * 十分钟看题解
 * <p>
 * 十分钟看答案
 */
public class GetMinimumDifference {
    class Solution {
        int pre = -1;
        int result = Integer.MAX_VALUE;

        public int getMinimumDifference(TreeNode root) {
            zhong(root);

            return result;
        }

        private void zhong(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                pre = root.val;
                return;
            }
            zhong(root.left);
            if (pre != -1) {
                result = Math.min(result, Math.abs(root.val - pre));
            }
            pre = root.val;
            zhong(root.right);
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
