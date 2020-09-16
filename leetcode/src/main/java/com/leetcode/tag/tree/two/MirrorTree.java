package com.leetcode.tag.tree.two;

/**
 * 剑指 Offer 27. 二叉树的镜像
 */
public class MirrorTree {
    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode left = mirrorTree(root.left);
            TreeNode right = mirrorTree(root.right);

            root.left = right;
            root.right = left;

            return root;
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
