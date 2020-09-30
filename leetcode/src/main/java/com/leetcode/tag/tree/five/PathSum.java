package com.leetcode.tag.tree.five;

import java.util.*;

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
                return;
            }
            stack.push(root.val);
            //叶子结点
            if (root.left == null && root.right == null && sum == root.val) {
                List<Integer> list = new ArrayList<>(stack);
                Collections.reverse(list);

                result.add(list);
            }
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
