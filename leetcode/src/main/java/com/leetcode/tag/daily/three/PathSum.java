package com.leetcode.tag.daily.three;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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

        private void pre(TreeNode root, int sum, List<List<Integer>> result, Deque<Integer> stack) {
            if (root == null || root.val > sum) {
                return;
            }
            if (sum == root.val) {
                stack.push(root.val);
                result.add(new ArrayList<>(stack));
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
