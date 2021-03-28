package com.leetcode.tag.tree.seven;

/**
 * 剑指 Offer 27. 二叉树的镜像
 */
public class MirrorTree {
    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(root.left);

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
