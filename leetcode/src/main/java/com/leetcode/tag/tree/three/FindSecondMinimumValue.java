package com.leetcode.tag.tree.three;

/**
 * 671. 二叉树中第二小的节点.
 * <p>
 * 十分钟看答案.学习答案.
 */
public class FindSecondMinimumValue {
    class Solution {
        int min = 1;
        int result;

        public int findSecondMinimumValue(TreeNode root) {
            pre(root);

            return min == 2 ? result : -1;
        }

        private void pre(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                if (root.left.val > root.val) {
                    min++;
                    if (min == 2) {
                        result = root.left.val;
                        return;
                    }
                    pre(root.left);
                }
            }
            if (root.right != null) {
                if (root.right.val > root.val) {
                    min++;
                    if (min == 2) {
                        result = root.right.val;
                        return;
                    }
                    pre(root.left);
                }
            }
        }
    }

    class Solution1 {
        long result = Long.MAX_VALUE;

        public int findSecondMinimumValue(TreeNode root) {
            pre(root, root.val);

            return result == Long.MAX_VALUE ? -1 : (int) result;
        }

        public void pre(TreeNode root, int rootVal) {
            if (root == null) {
                return;
            }
            if (root.val != rootVal) {
                result = Math.min(result, root.val);
            }
            pre(root.left, rootVal);
            pre(root.right, rootVal);
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
