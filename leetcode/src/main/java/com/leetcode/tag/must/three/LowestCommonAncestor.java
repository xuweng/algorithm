package com.leetcode.tag.must.three;

/**
 * 235. 二叉搜索树的最近公共祖先
 * <p>
 * 范围 区间
 * <p>
 * 左子树区间 右子树区间
 * <p>
 * 左子树大小区间 右子树大小区间
 */
public class LowestCommonAncestor {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            }

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
