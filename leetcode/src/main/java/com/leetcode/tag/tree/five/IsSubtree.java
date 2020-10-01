package com.leetcode.tag.tree.five;

/**
 * 572. 另一个树的子树
 * <p>
 * 这道题有点坑.难怪通过率这么低.
 */
public class IsSubtree {
    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) {
                return t == null;
            }
            if (t == null) {
                return false;
            }
            return (s.val == t.val && isSubtree(s.left, t.left) && isSubtree(s.right, t.right)) || (isSubtree(s.left, t)) || isSubtree(s.right, t);
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
