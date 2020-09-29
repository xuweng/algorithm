package com.leetcode.tag.tree.five;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 04.09. 二叉搜索树序列
 */
public class BSTSequences {
    class Solution {
        public List<List<Integer>> BSTSequences(TreeNode root) {
            if (root == null) {
                List<List<Integer>> lists = new ArrayList<>();
//                lists.add(new ArrayList<>());
                return lists;
            }
            if (root.left == null && root.right == null) {
                List<List<Integer>> lists = new ArrayList<>();
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                lists.add(list);

                return lists;
            }
            List<List<Integer>> lefts = BSTSequences(root.left);
            List<List<Integer>> rights = BSTSequences(root.right);
            List<List<Integer>> newLefts = new ArrayList<>();
            List<List<Integer>> newRights = new ArrayList<>();
            for (List<Integer> left : lefts) {
                if (rights.isEmpty()) {
                    List<Integer> list = new ArrayList<>();
                    list.add(root.val);
                    list.addAll(left);
                    newLefts.add(list);
                }
                for (List<Integer> right : rights) {
                    List<Integer> list = new ArrayList<>();
                    list.add(root.val);
                    list.addAll(left);
                    list.addAll(right);
                    newLefts.add(list);
                }
            }
            for (List<Integer> right : rights) {
                if (lefts.isEmpty()) {
                    List<Integer> list = new ArrayList<>();
                    list.add(root.val);
                    list.addAll(right);
                    newRights.add(list);
                }
                for (List<Integer> left : lefts) {
                    List<Integer> list = new ArrayList<>();
                    list.add(root.val);
                    list.addAll(right);
                    list.addAll(left);
                    newRights.add(list);
                }
            }
            List<List<Integer>> result = new ArrayList<>();
            result.addAll(newLefts);
            result.addAll(newRights);
            return result;
        }

        private void pre(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            pre(root.left, list);
            pre(root.right, list);
        }

        private void post(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            post(root.left, list);
            post(root.right, list);
            list.add(root.val);
        }
    }

    /**
     * 二叉搜索树没有重复元素, 而且每次递归的使用元素的顺序都不一样, 所以自动做到了去重
     */
    class Solution1 {
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> BSTSequences(TreeNode root) {
            if (root == null) {
                res.add(new LinkedList<>());
                return res;
            }

            LinkedList<Integer> path = new LinkedList<>();
            path.add(root.val);

            helper(root, new LinkedList<>(), path);

            return res;
        }

        public void helper(TreeNode root, LinkedList<TreeNode> queue, LinkedList<Integer> path) {
            if (root == null) {
                return;
            }

            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }

            if (queue.isEmpty()) {
                res.add(new LinkedList<>(path));
                return;
            }

            int lens = queue.size();
            for (int i = 0; i < lens; i++) {
                TreeNode cur = queue.get(i);
                queue.remove(i);
                path.add(cur.val);

                helper(cur, new LinkedList<>(queue), path);

                //回溯
                queue.add(i, cur);
                path.removeLast();
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
