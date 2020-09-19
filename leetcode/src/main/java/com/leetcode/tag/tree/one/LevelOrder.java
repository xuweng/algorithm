package com.leetcode.tag.tree.one;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 */
public class LevelOrder {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<List<Integer>> result = new ArrayList<>();

            levelOrder(root, result, 0);

            return result;
        }

        private void levelOrder(TreeNode root, List<List<Integer>> result, int high) {
            if (root == null) {
                return;
            }

            if (result.size() == high) {
                result.add(new ArrayList<>());
            }
            result.get(high).add(root.val);
            levelOrder(root.left, result, high + 1);
            levelOrder(root.right, result, high + 1);
        }
    }

    class Solution1 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> tmp = new ArrayList<>();
                int i = queue.size();
                while (i > 0) {
                    //出队
                    TreeNode node = queue.poll();
                    tmp.add(node.val);
                    //入队
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    i--;
                }
                res.add(tmp);
            }
            return res;
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
