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

    /**
     * 方法一：深度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/solution/er-cha-shu-de-ceng-ping-jun-zhi-by-leetcode-soluti/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Integer> counts = new ArrayList<>();
            List<Double> sums = new ArrayList<>();

            dfs(root, 0, counts, sums);

            List<Double> averages = new ArrayList<>();
            int size = sums.size();
            for (int i = 0; i < size; i++) {
                averages.add(sums.get(i) / counts.get(i));
            }
            return averages;
        }

        public void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
            if (root == null) {
                return;
            }
            if (level < sums.size()) {
                sums.set(level, sums.get(level) + root.val);
                counts.set(level, counts.get(level) + 1);
            } else {
                sums.add(1.0 * root.val);
                counts.add(1);
            }
            dfs(root.left, level + 1, counts, sums);
            dfs(root.right, level + 1, counts, sums);
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
