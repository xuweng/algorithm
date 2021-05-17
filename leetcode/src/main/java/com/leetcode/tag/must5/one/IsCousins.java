package com.leetcode.tag.must5.one;

/**
 * 993. 二叉树的堂兄弟节点
 */
public class IsCousins {
    class Solution {
        TreeNode head;
        TreeNode head1;

        public boolean isCousins(TreeNode root, int x, int y) {
            int i = dfs(null, root, x, true);
            int j = dfs(null, root, y, false);

            if (head == head1) {
                return false;
            }

            return i == j;
        }

        private int dfs(TreeNode parent, TreeNode root, int x, boolean is) {
            if (root == null) {
                return -1;
            }
            if (root.val == x) {
                if (is) {
                    head = parent;
                } else {
                    head1 = parent;
                }
                return 0;
            }
            int left = dfs(root, root.left, x, is);
            int right = dfs(root, root.right, x, is);
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
