package com.leetcode.tag.tree.five;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1161. 最大层内元素和
 * <p>
 * 十分钟看答案.十分钟看答案.
 */
public class MaxLevelSum {
    class Solution {
        int levelSum;
        Map<Integer, Integer> map = new HashMap<>();

        public int maxLevelSum(TreeNode root) {
            pre(root, 1);

            AtomicInteger result = new AtomicInteger();
            map.forEach((k, v) -> {
                if (v == levelSum) {
                    result.set(k);
                }
            });

            return result.get();
        }

        private void pre(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            if (map.containsKey(depth)) {
                map.put(depth, map.get(depth) + root.val);
            } else {
                map.put(depth, root.val);
            }
            levelSum = Math.max(levelSum, map.get(depth));
            pre(root.left, depth + 1);
            pre(root.right, depth + 1);
        }
    }

    class TreeNode {
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
