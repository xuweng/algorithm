package com.leetcode.tag.must.seven;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTree {
    class Solution {
        int postRootIndex;
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            postRootIndex = postorder.length - 1;

            return dfs(postorder, 0, postRootIndex);
        }

        private TreeNode dfs(int[] postorder, int low, int high) {
            if (low > high) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[postRootIndex]);
            Integer i = map.get(postorder[postRootIndex--]);
            root.right = dfs(postorder, i + 1, high);
            root.left = dfs(postorder, low, i - 1);

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
