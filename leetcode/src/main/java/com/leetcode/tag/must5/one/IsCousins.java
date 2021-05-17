package com.leetcode.tag.must5.one;

/**
 * 993. 二叉树的堂兄弟节点
 */
public class IsCousins {
    class Solution {
        TreeNode head;
        TreeNode head1;

        public boolean isCousins(TreeNode root, int x, int y) {
            int i = dfs(root, x);
            int j = dfs(root, y);

            if (head == head1) {
                return false;
            }

            return i == j;
        }

        private int dfs(TreeNode root, int x) {
            if (root == null) {
                return -1;
            }
            if (root.val == x) {
                return 0;
            }
            int left = dfs(root.left, x);
            int right = dfs(root.right, x);
            if (left == -1 && right == -1) {
                return -1;
            }

            return Math.max(left, right) + 1;
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
