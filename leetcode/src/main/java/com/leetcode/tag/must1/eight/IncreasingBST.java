package com.leetcode.tag.must1.eight;

/**
 * 897. 递增顺序搜索树
 */
public class IncreasingBST {
    class Solution {
        public TreeNode increasingBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = increasingBST(root.left);
            if (left == null) {
                return increasingBST(root.right);
            }
            TreeNode right = increasingBST(root.right);

            left.right = root;
            root.right = right;

            return left;
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
