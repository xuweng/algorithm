package com.leetcode.tag.tree.six;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 */
public class BuildTree {
    class Solution {
        int rootIndex;
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
                return null;
            }
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return help(preorder, 0, preorder.length - 1);
        }

        private TreeNode help(int[] preorder, int low, int high) {
            if (low > high) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[rootIndex]);
            int index = map.get(preorder[rootIndex++]);
            root.left = help(preorder, low, index - 1);
            root.right = help(preorder, index + 1, high);
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
