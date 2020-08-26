package com.leetcode.tag.tree;

import java.util.ArrayList;
import java.util.List;

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
            levelOrder(root, result, high + 1);
            levelOrder(root, result, high + 1);
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
