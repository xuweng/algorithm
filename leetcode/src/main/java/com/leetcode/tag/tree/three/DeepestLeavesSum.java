package com.leetcode.tag.tree.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 */
public class DeepestLeavesSum {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public int deepestLeavesSum(TreeNode root) {
            if (root == null) {
                return 0;
            }

            level(root, 0);

            return result.get(result.size() - 1).stream().mapToInt(i -> i).sum();
        }

        private void level(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (result.size() == level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            level(root.left, level + 1);
            level(root.right, level + 1);
        }
    }

    /**
     * bfs
     */
    class Solution1 {
        public int deepestLeavesSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            //每层的和
            int sum = 0;
            while (!queue.isEmpty()) {
                //清0
                sum = 0;
                int count = queue.size();
                for (int i = 0; i < count; i++) {
                    root = queue.poll();
                    sum += root.val;
                    if (root.left != null) {
                        queue.offer(root.left);
                    }
                    if (root.right != null) {
                        queue.offer(root.right);
                    }
                }
            }
            return sum;
        }
    }

    /**
     * dfs
     */
    class Solution2 {
        int maxDepth = -1;
        int sum = 0;

        public int deepestLeavesSum(TreeNode root) {
            return dfs(root, 0);
        }

        private int dfs(TreeNode root, int depth) {
            if (root == null) {
                return 0;
            }
            if (maxDepth < depth) {
                maxDepth = depth;
                sum = root.val;
            } else if (depth == maxDepth) {
                sum += root.val;
            }
            if (root.left != null) {
                dfs(root.left, depth + 1);
            }
            if (root.right != null) {
                dfs(root.right, depth + 1);
            }
            return sum;
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
