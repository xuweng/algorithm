package com.leetcode.tag.tree.three;

/**
 * 993. 二叉树的堂兄弟节点
 */
public class IsCousins {
    class Solution {
        boolean findX;
        boolean findY;
        TreeNode parentX;
        TreeNode parentY;
        int depthX;
        int depthY;

        public boolean isCousins(TreeNode root, int x, int y) {
            isCousins(root, x, y, null, 0);

            return (parentX != parentY) && (depthX == depthY);
        }

        private void isCousins(TreeNode root, int x, int y, TreeNode parent, int depth) {
            if ((root == null) || (findX && findY)) {
                return;
            }
            if (root.val == x) {
                findX = true;
                parentX = parent;
                depthX = depth;
            }
            if (root.val == y) {
                findY = true;
                parentY = parent;
                depthY = depth;
            }
            isCousins(root.left, x, y, root, depth + 1);
            isCousins(root.right, x, y, root, depth + 1);
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
