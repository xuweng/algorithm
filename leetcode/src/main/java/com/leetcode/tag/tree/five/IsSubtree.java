package com.leetcode.tag.tree.five;

/**
 * 572. 另一个树的子树
 * <p>
 * 这道题有点坑.难怪通过率这么低.
 */
public class IsSubtree {
    class Solution {
        boolean result;

        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) {
                return t == null;
            }
            if (t == null) {
                return false;
            }
            preorder(s, t);

            return result;
        }

        private void preorder(TreeNode s, TreeNode t) {
            if (s == null || result) {
                return;
            }
            if (s.val == t.val) {
                result = myIsSubtree(s, t);
            }
            preorder(s.left, t);
            preorder(s.right, t);
        }

        public boolean myIsSubtree(TreeNode s, TreeNode t) {
            if (s == null) {
                return t == null;
            }
            if (t == null || s.val != t.val) {
                return false;
            }
            return myIsSubtree(s.left, t.left) && myIsSubtree(s.right, t.right);
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
