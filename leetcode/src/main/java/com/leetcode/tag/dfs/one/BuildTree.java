package com.leetcode.tag.dfs.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTree {
    class Solution {
        int rootIndex;
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            rootIndex = postorder.length - 1;
            return buildTree(postorder, 0, postorder.length - 1);
        }

        public TreeNode buildTree(int[] postorder, int low, int high) {
            //low和high确定终止条件
            if (low > high) {
                return null;
            }
            TreeNode node = new TreeNode(postorder[rootIndex]);
            int root = map.get(postorder[rootIndex--]);
            node.right = buildTree(postorder, root + 1, high);
            node.left = buildTree(postorder, low, root - 1);

            return node;
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
