package com.leetcode.tag.daily.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTree {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        public TreeNode buildTree(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
            if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
                return null;
            }
            if (inorderStart == inorderEnd || postorderStart == postorderEnd) {
                return new TreeNode(inorder[inorderStart]);
            }
            TreeNode root = new TreeNode(postorder[postorderEnd]);
            int l = map.get(postorderEnd);
            root.left = buildTree(inorder, inorderStart, l - 1, postorder, postorderStart, postorderStart + l - inorderStart - 1);
            root.right = buildTree(inorder, l + 1, inorderEnd, postorder, postorderStart + l - inorderStart, postorderEnd - 1);
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
