package com.leetcode.tag.must3.two;

/**
 * 剑指 Offer 26. 树的子结构
 */
public class IsSubStructure {
    class Solution {
        /**
         * 先序遍历树 A 中的每个节点 A
         *
         * @param A
         * @param B
         * @return
         */
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {
                // 空树不是任意一个树的子结构
                return false;
            }
            // 只要有ture就返回
            return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        /**
         * 判断树 A 中 以 A为根节点的子树 是否包含树 B
         *
         * @param A
         * @param B
         * @return
         */
        public boolean recur(TreeNode A, TreeNode B) {
            if (B == null) {
                // 只要b==null b配匹完
                return true;
            }
            if (A == null || A.val != B.val) {
                return false;
            }
            return recur(A.left, B.left) && recur(A.right, B.right);
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
