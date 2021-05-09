package com.leetcode.tag.must3.three;

/**
 * 剑指 Offer 26. 树的子结构
 * <p>
 * 数据范围 数据范围 数据范围
 * <p>
 * 数据范围 数据范围 数据范围
 * <p>
 * 数据范围 数据范围  数据范围
 */
public class IsSubStructure {
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            // 没有配匹成功
            if (A == null || B == null) {
                return false;
            }

            // 只要有true就返回
            return is(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean is(TreeNode A, TreeNode B) {
            // b已经配匹完
            if (B == null) {
                return true;
            }
            // a已经配匹完，b没有配匹完
            if (A == null) {
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
