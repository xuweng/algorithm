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
            //选择root
            int max = root.val;
            if (root.left != null) {
                max += rob(root.left.left);
                max += rob(root.left.right);
            }
            if (root.right != null) {
                max += rob(root.right.left);
                max += rob(root.right.right);
            }
            //不选择root
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
