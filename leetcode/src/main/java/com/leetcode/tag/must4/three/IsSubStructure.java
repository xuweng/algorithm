package com.leetcode.tag.must4.three;

/**
 * 剑指 Offer 26. 树的子结构
 */
public class IsSubStructure {
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {
                return false;
            }

            return is(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean is(TreeNode a, TreeNode b) {
            if (b == null) {
                // b已经配匹完
                return true;
            }
            if (a == null) {
                // b没有配匹完 a已经配匹完
                return false;
            }
            if (a.val != b.val) {
                return false;
            }

            return is(a.left, b.left) && is(a.right, b.right);
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
