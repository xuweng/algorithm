package com.leetcode.tag.must3.four;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * <p>
 * 代码掌控度 代码掌控度
 */
public class LevelOrder {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
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
            result.get(depth).add(root.val);
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
