package com.leetcode.tag.tree.four;

/**
 * 337. 打家劫舍 III
 */
public class Rob {
    class Solution {
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int max = root.val;
            if (root.left.left != null) {
                max += rob(root.left.left);
            }
            if (root.right.right != null) {
                max += rob(root.right.right);
            }
            int max1 = rob(root.left) + rob(root.right);

            return Math.max(max, max1);
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
