package com.leetcode.tag.dfs.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 1530. 好叶子节点对的数量
 * <p>
 * 树形dp.树形dp.
 */
public class CountPairs {
    static class Solution {
        int result;

        public int countPairs(TreeNode root, int distance) {
            post(root, distance);

            return result;
        }

        public List<Integer> post(TreeNode root, int distance) {
            if (root == null) {
                return new ArrayList<>();
            }
            if (root.left == null && root.right == null) {
                List<Integer> list = new ArrayList<>();
                list.add(0);
                return list;
            }
            List<Integer> left = post(root.left, distance);
            List<Integer> right = post(root.right, distance);
            for (int i = 0; i < left.size(); i++) {
                left.set(i, left.get(i) + 1);
            }
            for (int i = 0; i < right.size(); i++) {
                right.set(i, right.get(i) + 1);
            }
            for (Integer i : left) {
                for (Integer j : right) {
                    if (i + j <= distance) {
                        result++;
                    }
                }
            }
            List<Integer> list = new ArrayList<>(left);
            list.addAll(right);
            return list;
        }
    }

    static class TreeNode {
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
