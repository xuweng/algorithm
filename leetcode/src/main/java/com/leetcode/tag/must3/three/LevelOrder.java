package com.leetcode.tag.must3.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 */
public class LevelOrder {
    class Solution {
        List<Integer> result = new ArrayList<>();

        public int[] levelOrder(TreeNode root) {
            dfs(root, 0);

            return result.stream().mapToInt(integer -> integer).toArray();
        }

        private void dfs(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            result.add(depth, root.val);

            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);
        }
    }

    class Solution1 {
        List<Integer> result = new ArrayList<>();

        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            bfs(root);

            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        private void bfs(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    result.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }
    }

    class Solution2 {
        List<List<Integer>> result = new ArrayList<>();

        public int[] levelOrder(TreeNode root) {
            levelOrder(root, 0);

            List<Integer> list = new ArrayList<>();
            for (List<Integer> l : result) {
                list.addAll(l);
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        public void levelOrder(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (result.size() == level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            levelOrder(root.left, level + 1);
            levelOrder(root.right, level + 1);
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
