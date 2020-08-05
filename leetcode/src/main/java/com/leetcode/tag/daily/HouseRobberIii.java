package com.leetcode.tag.daily;

import java.util.HashMap;

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
         * 发现自己写的算法执行不通过。知道哪里错。
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
                leftMax = rob(root.left.left) + rob(root.left.right);
            }
            if (root.right != null) {
                rightMax = rob(root.right.left) + rob(root.right.right);
            }
            int max1 = rob(root.left) + rob(root.right);
            int max2 = root.val + leftMax + rightMax;

            return Math.max(max1, max2);
        }
    }

    class Solution1 {
        public int rob(TreeNode root) {
            int[] result = robInternal(root);
            return Math.max(result[0], result[1]);
        }

        public int[] robInternal(TreeNode root) {
            if (root == null) {
                return new int[2];
            }
            int[] result = new int[2];

            int[] left = robInternal(root.left);
            int[] right = robInternal(root.right);

            result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            result[1] = left[0] + right[0] + root.val;

            return result;
        }
    }

    class Solution2 {
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }

            // max(选择root,不选择root)
            int money = root.val;
            if (root.left != null) {
                money += (rob(root.left.left) + rob(root.left.right));
            }

            if (root.right != null) {
                money += (rob(root.right.left) + rob(root.right.right));
            }

            return Math.max(money, rob(root.left) + rob(root.right));
        }
    }

    class Solution3 {
        public int rob(TreeNode root) {
            HashMap<TreeNode, Integer> memo = new HashMap<>();
            return robInternal(root, memo);
        }

        public int robInternal(TreeNode root, HashMap<TreeNode, Integer> memo) {
            if (root == null) {
                return 0;
            }
            if (memo.containsKey(root)) {
                return memo.get(root);
            }
            int money = root.val;

            if (root.left != null) {
                money += (robInternal(root.left.left, memo) + robInternal(root.left.right, memo));
            }
            if (root.right != null) {
                money += (robInternal(root.right.left, memo) + robInternal(root.right.right, memo));
            }
            int result = Math.max(money, robInternal(root.left, memo) + robInternal(root.right, memo));
            memo.put(root, result);

            return result;
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
