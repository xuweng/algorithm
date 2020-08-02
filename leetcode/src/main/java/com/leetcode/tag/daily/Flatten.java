package com.leetcode.tag.daily;

/**
 * 114. 二叉树展开为链表
 */
public class Flatten {
    /**
     * 算法是一种思维。代表一个人的思考。
     */
    class Solution {
        /**
         * 代码跟着示例走一遍
         *
         * @param root
         */
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            re(root);
        }

        /**
         * 算法错误。3形成一个环。
         *
         * @param root
         * @return
         */
        private TreeNode re(TreeNode root) {
            if (root == null) {
                return null;
            }
            //叶子结点
            boolean isLeaf = (root.left == null && root.right == null);
            if (isLeaf) {
                return root;
            }
            TreeNode node = leftRight(root.left);
            //保存
            TreeNode right = root.right;
            root.right = re(root.left);
            if (node != null) {
                node.right = re(right);
            }
            return root;
        }

        /**
         * 由于形成环。这里遍历就会报错。
         *
         * @param root
         * @return
         */
        private TreeNode leftRight(TreeNode root) {
            if (root == null) {
                return null;
            }
            if (root.right == null) {
                return root;
            }
            return leftRight(root.right);
        }
    }

    public static class TreeNode {
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

