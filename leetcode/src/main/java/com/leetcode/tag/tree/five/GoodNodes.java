package com.leetcode.tag.tree.five;

/**
 * 1448. 统计二叉树中好节点的数目
 * <p>
 * 树形dp.熟悉树形dp.
 */
public class GoodNodes {
    class Solution {
        int result;

        public int goodNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            pre(root, root.val);

            return result;
        }

        private void pre(TreeNode root, int max) {
            if (root == null) {
                return;
            }
            max = Math.max(max, root.val);
            if (root.val >= max) {
                result++;
            }
            pre(root.left, max);
            pre(root.right, max);
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
