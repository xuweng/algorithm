package com.leetcode.tag.daily.three;

import java.util.*;

/**
 * 501. 二叉搜索树中的众数
 */
public class FindMode {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public int[] findMode(TreeNode root) {
            zhong(root);

            Integer max = map.values().stream().max(Integer::compareTo).orElse(0);

            List<Integer> result = new ArrayList<>();
            map.forEach((k, v) -> {
                if (Objects.equals(v, max)) {
                    result.add(k);
                }
            });

            //转换为数组这么简单.记住.
            return result.stream().mapToInt(item -> item).toArray();
        }

        private void zhong(TreeNode root) {
            if (root == null) {
                return;
            }
            zhong(root.left);
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            zhong(root.right);
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
