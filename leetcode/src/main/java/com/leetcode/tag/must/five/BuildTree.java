package com.leetcode.tag.must.five;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {
    class Solution {
        int index;
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return dfs(preorder, 0, preorder.length - 1);
        }

        private TreeNode dfs(int[] preorder, int low, int high) {
            if (low > high) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[index]);
            Integer i = map.get(preorder[index++]);
            root.left = dfs(preorder, low, i - 1);
            root.right = dfs(preorder, i + 1, high);

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
