package com.leetcode.tag.tree.five;

/**
 * 513. 找树左下角的值
 */
public class FindBottomLeftValue {
    class Solution {
        int result;
        int maxDepth = -1;

        public int findBottomLeftValue(TreeNode root) {
            pre(root, 0);

            return result;
        }

        private void pre(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            if (depth > maxDepth) {
                result = root.val;
                maxDepth = depth;
            }
            pre(root.left, depth + 1);
            pre(root.right, depth + 1);
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
