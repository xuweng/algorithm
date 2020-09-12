package com.leetcode.tag.daily.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 637. 二叉树的层平均值
 */
public class AverageOfLevels {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<Double> averageOfLevels(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            ceng(root, 0);

            List<Double> list = new ArrayList<>();
            for (List<Integer> integers : result) {
                double sum = integers.stream().mapToDouble(Integer::intValue).sum();
                list.add(sum / integers.size());
            }

            return list;
        }

        private void ceng(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (level == result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            ceng(root.left, level + 1);
            ceng(root.right, level + 1);
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
