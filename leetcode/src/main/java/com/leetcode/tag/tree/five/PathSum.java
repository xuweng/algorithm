package com.leetcode.tag.tree.five;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 */
public class PathSum {
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new ArrayList<>();
            Deque<Integer> stack = new LinkedList<>();

            back(root, sum, result, stack);

            return result;
        }

        private void back(TreeNode root, int sum, List<List<Integer>> result, Deque<Integer> stack) {
            if (root == null) {
                if (sum == 0) {
                    result.add(new ArrayList<>(stack));
                }
                return;
            }
            stack.push(root.val);
            back(root.left, sum - root.val, result, stack);
            back(root.right, sum - root.val, result, stack);
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
