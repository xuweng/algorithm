package com.leetcode.tag.must1.eight;

/**
 * 897. 递增顺序搜索树
 */
public class IncreasingBST {
    class Solution {
        TreeNode pre;

        public TreeNode increasingBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode result = findMin(root);
            dfs(root);

            return result;
        }

        void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            if (pre != null) {
                pre.right = root;
                root.left = null;
            }
            pre = root;

            dfs(root.right);
        }

        TreeNode findMax(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode node = root;
            while (node.right != null) {
                node = node.right;
            }

            return node;
        }


        TreeNode findMin(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode node = root;
            while (node.left != null) {
                node = node.left;
            }

            return node;
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
