package com.leetcode.tag.tree.five;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 508. 出现次数最多的子树元素和
 */
public class FindFrequentTreeSum {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        int count;

        public int[] findFrequentTreeSum(TreeNode root) {
            dfs(root);

            List<Integer> list = new ArrayList<>();
            map.forEach((k, v) -> {
                if (v == count) {
                    list.add(k);
                }
            });
            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int sum = dfs(root.left) + dfs(root.right) + root.val;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            count = Math.max(count, map.get(sum));
            return sum;
        }
    }

    /**
     * 减少遍历次数
     */
    class Solution1 {
        private int max;
        private final ArrayList<Integer> list = new ArrayList<>();
        private final HashMap<Integer, Integer> map = new HashMap<>();

        public int[] findFrequentTreeSum(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            dfs(root);

            return list.stream().mapToInt(integer -> integer).toArray();
        }

        /**
         * 减少遍历次数
         *
         * @param root
         * @return
         */
        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            int sum = left + right + root.val;
            int current = map.getOrDefault(sum, 0) + 1;
            map.put(sum, current);
            if (current == max) {
                list.add(sum);
            } else if (current > max) {
                //这个清空厉害
                list.clear();
                list.add(sum);
                max = current;
            }
            return sum;
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
