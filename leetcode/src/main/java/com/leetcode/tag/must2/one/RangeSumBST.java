package com.leetcode.tag.must2.one;

/**
 * 938. 二叉搜索树的范围和
 */
public class RangeSumBST {
    class Solution {
        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) {
                return 0;
            }
            if (high < root.val) {
                return rangeSumBST(root.left, low, high);
            }
            if (low > root.val) {
                return rangeSumBST(root.right, low, high);
            }

            return root.val + rangeSumBST(root.left, low, root.val) + rangeSumBST(root.right, root.val, high);
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
