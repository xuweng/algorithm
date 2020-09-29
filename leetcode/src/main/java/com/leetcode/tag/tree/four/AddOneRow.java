package com.leetcode.tag.tree.four;

/**
 * 623. 在二叉树中增加一行
 */
public class AddOneRow {
    /**
     * 增加一行会改变原来tree的结构.
     */
    class Solution {
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if (d == 1) {
                TreeNode node = new TreeNode(v);
                node.left = root;
                return node;
            }

            pre(root, v, d, 1);

            return root;
        }

        public void pre(TreeNode root, int v, int d, int depth) {
            if (root == null) {
                return;
            }
            if (depth == d - 1) {
                TreeNode left = root.left;
                TreeNode right = root.right;

                root.left = new TreeNode(v);
                root.right = new TreeNode(v);
                root.left.left = left;
                root.right.right = right;
            }

            pre(root.left, v, d, depth + 1);
            pre(root.right, v, d, depth + 1);
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
