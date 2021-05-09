package com.leetcode.tag.must3.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
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

        private TreeNode dfs(int[] preorder, int i, int j) {
            if (i > j) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[index]);
            Integer integer = map.get(preorder[index++]);
            root.left = dfs(preorder, i, integer - 1);
            root.right = dfs(preorder, integer + 1, j);

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
