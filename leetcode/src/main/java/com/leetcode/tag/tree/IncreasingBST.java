package com.leetcode.tag.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 897. 递增顺序查找树
 */
public class IncreasingBST {
    class Solution {
        public TreeNode increasingBST(TreeNode root) {
            if (root == null) {
                return null;
            }

            List<TreeNode> result = new ArrayList<>();

            zhong(root, result);

            for (int i = 0; i < result.size() - 1; i++) {
                TreeNode treeNode = result.get(i);
                treeNode.left = null;
                treeNode.right = result.get(i + 1);
            }
            return result.get(0);
        }

        private void zhong(TreeNode root, List<TreeNode> result) {
            if (root == null) {
                return;
            }
            zhong(root.left, result);
            result.add(root);
            zhong(root.right, result);
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
