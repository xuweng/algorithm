package com.leetcode.tag.must3.five;

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

        private boolean is(TreeNode A, TreeNode B) {
            if (B == null) {
                // b已经配匹完
                return true;
            }
            if (A == null) {
                // b没有配匹完 a已经配匹完
                return false;
            }
            if (A.val != B.val) {
                return false;
            }

            return is(A.left, B.left) && is(A.right, B.right);
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
