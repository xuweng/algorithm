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

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
