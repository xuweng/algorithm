package com.leetcode.tag.tree.four;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 */
public class LevelOrder {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public int[] levelOrder(TreeNode root) {
            levelOrder(root, 0);

            List<Integer> list = new ArrayList<>();
            for (List<Integer> l : result) {
                list.addAll(l);
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        public void levelOrder(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (result.size() == level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            levelOrder(root.left, level + 1);
            levelOrder(root.right, level + 1);
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
