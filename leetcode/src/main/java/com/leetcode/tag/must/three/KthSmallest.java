package com.leetcode.tag.must.three;

/**
 * 230. 二叉搜索树中第K小的元素
 * <p>
 * 排列去重 排列去重 排列去重
 * <p>
 * 正序 倒序 外循环
 */
public class KthSmallest {
    class Solution {
        int count = 1;
        int result;

        public int kthSmallest(TreeNode root, int k) {
            dfs(root, k);

            return result;
        }

        private void dfs(TreeNode root, int k) {
            if (root == null) {
                return;
            }
            dfs(root.left, k);
            if (count == k) {
                result = root.val;
                return;
            }
            count++;
            dfs(root.right, k);
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
