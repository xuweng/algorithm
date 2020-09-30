package com.leetcode.tag.tree.five;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTree {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
                return null;
            }
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
        }

        public TreeNode buildTree(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
            if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
                return null;
            }

            TreeNode root = new TreeNode(postorder[postorderEnd]);
            int rootIndex = map.get(postorder[postorderEnd]);
            root.left = buildTree(inorder, inorderStart, rootIndex - 1, postorder, postorderStart, postorderStart + rootIndex - inorderStart - 1);
            root.right = buildTree(inorder, rootIndex + 1, inorderEnd, postorder, postorderStart + rootIndex - inorderStart, postorderEnd - 1);

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
