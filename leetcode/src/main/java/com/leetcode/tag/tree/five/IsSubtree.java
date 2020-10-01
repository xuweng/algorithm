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

    /**
     * 先序遍历
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree/solution/ling-yi-ge-shu-de-zi-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 简洁代码.
         * <p>
         * 简单的先序遍历
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isSubtree(TreeNode s, TreeNode t) {
            return s != null && (check(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
        }

        public boolean check(TreeNode s, TreeNode t) {
            if (s == null) {
                return t == null;
            }
            if (t == null || s.val != t.val) {
                return false;
            }
            return check(s.left, t.left) && check(s.right, t.right);
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
