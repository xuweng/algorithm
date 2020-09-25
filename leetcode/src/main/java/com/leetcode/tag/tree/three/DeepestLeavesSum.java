package com.leetcode.tag.tree.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 1302. 层数最深叶子节点的和
 */
public class DeepestLeavesSum {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public int deepestLeavesSum(TreeNode root) {
            return result.get(result.size() - 1).stream().mapToInt(i -> i).sum();
        }

        private void level(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (result.size() == level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            level(root.left, level + 1);
            level(root.right, level + 1);
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
