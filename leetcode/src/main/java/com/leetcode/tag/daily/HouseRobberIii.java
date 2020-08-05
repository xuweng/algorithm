package com.leetcode.tag.daily;

/**
 * 337. 打家劫舍 III
 * <p>
 * 2个示例已经很明显。以root为标准。
 */
public class HouseRobberIii {
    class Solution {
        /**
         * 写完代码后在脑海里执行所有的测试用例
         * <p>
         * 发现自己写的算法执行不通过
         *
         * @param root
         * @return
         */
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return root.val;
            }
            int leftMax = 0;
            int rightMax = 0;
            if (root.left != null) {
                leftMax = Math.max(rob(root.left.left), rob(root.left.right));
            }
            if (root.right != null) {
                rightMax = Math.max(rob(root.right.left), rob(root.right.right));
            }
            int max1 = rob(root.left) + rob(root.right);
            int max2 = root.val + leftMax + rightMax;

            return Math.max(max1, max2);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
