package com.leetcode.tag.tree.five;

/**
 * 951. 翻转等价二叉树
 */
public class FlipEquiv {
    class Solution {
        boolean result = true;

        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            pre(root1, root2);

            return result;
        }

        private void pre(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                return;
            }
            if (root1.left != null) {
                if (root2.left == null || root1.left.val != root2.left.val) {
                    TreeNode left = root1.left;
                    root1.left = root1.right;
                    root1.right = left;

                    boolean b = root1.left == null ? root2.left == null : root1.val == root2.val;
                    if (!b) {
                        result = false;
                        return;
                    }
                }
            }
            pre(root1.left, root2.left);
            pre(root1.right, root2.right);
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
