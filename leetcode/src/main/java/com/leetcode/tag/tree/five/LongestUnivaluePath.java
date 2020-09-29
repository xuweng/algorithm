package com.leetcode.tag.tree.five;

/**
 * 687. 最长同值路径
 */
public class LongestUnivaluePath {
    class Solution {
        int result;
        int count;

        public int longestUnivaluePath(TreeNode root) {
            post(root, Integer.MIN_VALUE);

            return result;
        }

        private void post(TreeNode root, int parent) {
            if (root == null) {
                return;
            }
            post(root.left, root.val);
            post(root.right, root.val);
            if (parent == root.val) {
                count++;
            } else {
                count = 0;
            }
            result = Math.max(result, count);
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
