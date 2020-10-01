package com.leetcode.tag.tree.five;

/**
 * 572. 另一个树的子树
 */
public class IsSubtree {
    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) {
                return t == null;
            }
            if (t == null || s.val != t.val) {
                return false;
            }
            return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
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
