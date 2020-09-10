package com.leetcode.tag.tree.two;

/**
 * 606. 根据二叉树创建字符串
 * <p>
 * 慢慢想
 */
public class Tree2Str {
    class Solution {
        public String tree2str(TreeNode t) {
            if (t == null) {
                return "()";
            }
            if (t.left == null && t.right == null) {
                return t.val + "";
            }

            String left = "(" + tree2str(t.left) + ")";
            String right = "(" + tree2str(t.right) + ")";

            return t.val + left + right;
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
