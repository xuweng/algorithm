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
        List<List<Integer>> result = new ArrayList<>();

        public int[] levelOrder(TreeNode root) {
            bfs(root);

            List<Integer> list = new ArrayList<>();
            for (List<Integer> l : result) {
                list.addAll(l);
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        private void bfs(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                List<Integer> temp = new ArrayList<>();
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    temp.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                result.add(temp);
            }
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
