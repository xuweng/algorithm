package com.leetcode.tag.tree.three;

/**
 * 1315. 祖父节点值为偶数的节点和
 * <p>
 * 3个状态.反序遍历
 */
public class SumEvenGrandparent {
    class Solution {
        int sum;

        public int sumEvenGrandparent(TreeNode root) {
            sum(root);

            return sum;
        }

        private void sum(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.val % 2 == 0) {
                mySum(root.left);
                mySum(root.right);
            }
            sum(root.left);
            sum(root.right);

        }

        private void mySum(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                sum += root.left.val;
            }
            if (root.right != null) {
                sum += root.right.val;
            }
        }

    }

    /**
     * 先序遍历
     */
    class Solution1 {
        public int sumEvenGrandparent(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int res = 0;
            if (root.val % 2 == 0) {
                if (root.left != null) {
                    if (root.left.left != null) {
                        res += root.left.left.val;
                    }
                    if (root.left.right != null) {
                        res += root.left.right.val;
                    }

                }
                if (root.right != null) {
                    if (root.right.left != null) {
                        res += root.right.left.val;
                    }
                    if (root.right.right != null) {
                        res += root.right.right.val;
                    }
                }
            }
            return res + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
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
