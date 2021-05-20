package com.leetcode.tag.must4.four;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 */
public class BuildTree {
    class Solution {
        int root;
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return dfs(preorder, 0, preorder.length - 1);
        }

        private TreeNode dfs(int[] preorder, int left, int right) {
            if (left > right) {
                return null;
            }
            TreeNode treeNode = new TreeNode(preorder[root]);
            Integer integer = map.get(preorder[root++]);
            treeNode.left = dfs(preorder, left, integer - 1);
            treeNode.right = dfs(preorder, integer + 1, right);

            return treeNode;
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
