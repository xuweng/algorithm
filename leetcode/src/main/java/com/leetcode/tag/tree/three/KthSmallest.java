package com.leetcode.tag.tree.three;

/**
 * 230. 二叉搜索树中第K小的元素
 * <p>
 * 反序遍历.反序遍历.反序遍历
 */
public class KthSmallest {
    class Solution {
        int count;
        int result;

        public int kthSmallest(TreeNode root, int k) {
            zhong(root, k);

            return result;
        }

        private void zhong(TreeNode root, int k) {
            if (root == null) {
                return;
            }
            zhong(root.left, k);
            count++;
            if (count == k) {
                result = root.val;
                return;
            }

            zhong(root.right, k);
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
