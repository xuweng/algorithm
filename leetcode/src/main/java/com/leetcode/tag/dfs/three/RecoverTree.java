package com.leetcode.tag.dfs.three;

/**
 * 99. 恢复二叉搜索树
 */
public class RecoverTree {
    class Solution {
        TreeNode pre;
        TreeNode p1;
        TreeNode p2;

        public void recoverTree(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root);

            if (p1 == null || p2 == null) {
                return;
            }

            int temp = p1.val;
            p1.val = p2.val;
            p2.val = temp;
        }

        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);

            if (pre != null) {
                if (pre.val > root.val) {
                    p1 = p1 == null ? pre : p1;
                    p2 = root;
                }
            }
            pre = root;

            dfs(root.right);
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
