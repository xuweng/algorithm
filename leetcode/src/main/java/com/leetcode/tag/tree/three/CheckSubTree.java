package com.leetcode.tag.tree.three;

/**
 * 面试题 04.10. 检查子树
 */
public class CheckSubTree {
    class Solution {
        public boolean checkSubTree(TreeNode t1, TreeNode t2) {
            if (t1 == null) {
                return t2 == null;
            }
            if (t2 == null) {
                return false;
            }
            if (t1.val == t2.val) {
                return checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
            } else {
                return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
            }
        }
    }

    /**
     *
     */
    class Solution1 {
        public boolean checkSubTree(TreeNode t1, TreeNode t2) {
            return (t1 != null && t2 != null) &&
                    (recur(t1, t2) || checkSubTree(t1.right, t2) || checkSubTree(t1.left, t2));
        }

        /**
         * t1和t2相等
         *
         * @param t1
         * @param t2
         * @return
         */
        private boolean recur(TreeNode t1, TreeNode t2) {
            if (t2 == null) {
                return true;
            }
            if (t1 == null || t1.val != t2.val) {
                return false;
            }
            return recur(t1.left, t2.left) && recur(t2.right, t2.right);
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
