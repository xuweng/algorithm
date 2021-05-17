package com.leetcode.tag.must5.one;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 872. 叶子相似的树
 */
public class LeafSimilar {
    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> list = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();

            dfs(root1, list);
            dfs(root2, list1);

            return list.equals(list1);
        }

        private void dfs(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                list.add(root.val);
            }
            dfs(root.left, list);
            dfs(root.right, list);
        }
    }

    class Solution1 {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> list = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();

            dfs(root1, list);
            dfs(root2, list1);

            return list.equals(list1);
        }

        private void dfs(TreeNode root, List<Integer> list) {
            Deque<TreeNode> deque = new LinkedList<>();
            while (root != null || !deque.isEmpty()) {
                while (root != null) {
                    // root先全部入栈
                    deque.push(root);
                    root = root.left;
                }
                TreeNode pop = deque.pop();
                if (pop.left == null && pop.right == null) {
                    list.add(pop.val);
                }
                // 切换到right
                root = pop.right;
            }
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
