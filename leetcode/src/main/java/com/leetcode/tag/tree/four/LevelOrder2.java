package com.leetcode.tag.tree.four;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 */
public class LevelOrder2 {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            pre(root, 0);

            return result;
        }

        private void pre(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (result.size() == level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            pre(root.left, level + 1);
            pre(root.right, level + 1);
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
