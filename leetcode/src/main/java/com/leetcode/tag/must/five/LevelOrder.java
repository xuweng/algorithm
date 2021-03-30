package com.leetcode.tag.must.five;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
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
