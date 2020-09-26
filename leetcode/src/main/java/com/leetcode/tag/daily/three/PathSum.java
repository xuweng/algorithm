package com.leetcode.tag.daily.three;

import java.util.*;

/**
 * 113. 路径总和 II
 */
public class PathSum {
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new ArrayList<>();
            Deque<Integer> stack = new LinkedList<>();

            pre(root, sum, result, stack);

            return result;
        }

        /**
         * root.val和sum可能是负数
         *
         * @param root
         * @param sum
         * @param result
         * @param stack
         */
        private void pre(TreeNode root, int sum, List<List<Integer>> result, Deque<Integer> stack) {
            if (root == null) {
                return;
            }
            //叶子结点
            if (root.left == null && root.right == null && sum == root.val) {
                stack.push(root.val);
                List<Integer> list = new ArrayList<>(stack);
                Collections.reverse(list);
                result.add(list);
                stack.pop();
                return;
            }
            stack.push(root.val);
            pre(root.left, sum - root.val, result, stack);
            stack.pop();

            stack.push(root.val);
            pre(root.right, sum - root.val, result, stack);
            stack.pop();
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
