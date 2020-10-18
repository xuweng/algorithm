package com.leetcode.tag.dfs.two;

/**
 * 98. 验证二叉搜索树
 * <p>
 * 用示例来理解代码
 * <p>
 * 用示例来执行代码
 */
public class IsValidBST {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean dfs(TreeNode root, long min, long max) {
            if (root == null) {
                return true;
            }
            if (root.val <= min || root.val >= max) {
                return false;
            }
            return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
        }
    }

    class Solution1 {
        TreeNode pre = null;
        boolean result = true;

        public boolean isValidBST(TreeNode root) {
            //中序遍历
            dfs(root);

            return result;
        }

        private void dfs(TreeNode root) {
            if (root == null || !result) {
                return;
            }
            dfs(root.left);

            if (pre != null) {
                if (pre.val >= root.val) {
                    result = false;
                    return;
                }
            }
            pre = root;

            dfs(root.right);
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
