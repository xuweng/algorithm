package com.leetcode.tag.must.three;

/**
 * 538. 把二叉搜索树转换为累加树
 */
public class ConvertBST {
    class Solution {
        int pre;

        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            convertBST(root.left);

            root.val += pre;
            pre = root.val;

            convertBST(root.right);

            return root;
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
