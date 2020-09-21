package com.leetcode.tag.tree.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 */
public class LevelOrder {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            level(root, 0);

            for (int i = 1; i < result.size(); i += 2) {
                Collections.reverse(result.get(i));
            }

            return result;
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
