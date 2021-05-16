package com.leetcode.tag.must3.ten;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 */
public class LevelOrder {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return result;
            }

            dfs(root, 0);

            return result;
        }

        private void dfs(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            if (result.size() == depth) {
                result.add(new ArrayList<>());
            }
            if (depth % 2 == 0) {
                // 偶数 尾插
                result.get(depth).add(root.val);
            } else {
                // 奇数 头插
                result.get(depth).add(0, root.val);
            }
            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);
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
