package com.leetcode.tag.must3.four;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 */
public class LevelOrder1 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root != null) {
                queue.add(root);
            }
            while (!queue.isEmpty()) {
                LinkedList<Integer> tmp = new LinkedList<>();
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    if (res.size() % 2 == 0) {
                        // 尾插
                        tmp.addLast(node.val); // 偶数层 -> 队列头部
                    } else {
                        // 头插
                        tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                res.add(tmp);
            }
            return res;
        }
    }

    class Solution1 {
        private List<List<Integer>> ret = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            dfs(0, root);

            return ret;
        }

        private void dfs(int depth, TreeNode root) {
            if (root == null) {
                return;
            }
            if (ret.size() == depth) {
                ret.add(new LinkedList<>());
            }
            if ((depth & 1) == 1) {
                // 偶数 头插
                ret.get(depth).add(0, root.val);
            } else {
                // 奇数 尾插
                ret.get(depth).add(root.val);
            }
            dfs(depth + 1, root.left);
            dfs(depth + 1, root.right);
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
