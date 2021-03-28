package com.leetcode.tag.tree.seven;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree1 {
    class Solution {
        // 线性考虑
        // root left right
        int preRootIndex;
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return dfs(preorder, inorder, 0, preorder.length - 1);
        }

        private TreeNode dfs(int[] preorder, int[] inorder, int low, int high) {
            if (low > high) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preRootIndex]);
            Integer inRoot = map.get(preorder[preRootIndex++]);
            root.left = dfs(preorder, inorder, low, inRoot - 1);
            root.right = dfs(preorder, inorder, inRoot + 1, high);

            return root;
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
