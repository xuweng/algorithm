package com.leetcode.tag.tree.four;

/**
 * 1373. 二叉搜索子树的最大键值和
 */
public class MaxSumBST {
    class Solution {
        int result = Integer.MIN_VALUE;

        public int maxSumBST(TreeNode root) {
            int[] bst = bst(root);

            return result;
        }

        private int[] bst(TreeNode root) {
            if (root == null) {
                return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
            }
            int[] left = bst(root.left);
            int[] right = bst(root.right);
            int[] r = new int[4];
            if (left[0] == 1 && right[0] == 1 && (left[2] < root.val && root.val < right[1])) {
                r[0] = 1;
                r[1] = Math.min(left[1], root.val);
                r[2] = Math.max(right[2], root.val);
                r[3] = left[3] + right[3] + root.val;

                result = Math.max(result, r[3]);
            }
            return r;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
