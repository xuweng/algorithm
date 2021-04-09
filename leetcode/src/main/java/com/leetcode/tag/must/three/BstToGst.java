package com.leetcode.tag.must.three;

/**
 * 1038. 把二叉搜索树转换为累加树
 */
public class BstToGst {
    class Solution {
        int pre;

        public TreeNode bstToGst(TreeNode root) {
            if (root == null) {
                return null;
            }
            bstToGst(root.right);
            bstToGst(root.left);

            root.val += pre;
            pre = root.val;

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
