package com.leetcode.tag.tree.four;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 */
public class LevelOrder {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
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

    /**
     *
     */
    class Solution2 {
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            List<Integer> res = new ArrayList<>();

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode t = q.poll();
                res.add(t.val);
                if (t.left != null) {
                    q.offer(t.left);
                }
                if (t.right != null) {
                    q.offer(t.right);
                }
            }
            int[] t = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                t[i] = res.get(i);
            }
            return t;
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
