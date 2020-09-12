package com.leetcode.tag.tree.two;

/**
 * 617. 合并二叉树
 * <p>
 * 不纠结。不纠结。不纠结。不纠结
 */
public class MergeTrees {
    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return null;
            }
            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }

            TreeNode root = new TreeNode(t1.val + t2.val);
            TreeNode left = mergeTrees(t1.left, t2.left);
            TreeNode right = mergeTrees(t1.right, t2.right);

            root.left = left;
            root.right = right;

            return root;
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
