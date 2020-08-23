package com.leetcode.tag.daily.one;

/**
 * 100. 相同的树
 */
public class IsSameTree {
    class Solution {
        /**
         * 脑海里面执行一下测试用例
         *
         * @param p
         * @param q
         * @return
         */
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null || q == null) {
                return p == q;
            }
            return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public class TreeNode {
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
