package com.leetcode.tag.tree.five;

import java.util.HashMap;
import java.util.Map;

/**
 * 1161. 最大层内元素和
 * <p>
 * 十分钟看答案.十分钟看答案.
 */
public class MaxLevelSum {
    class Solution {
        int result;
        Map<Integer, Integer> map = new HashMap<>();

        public int maxLevelSum(TreeNode root) {
            pre(root, 1);

            return result;
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
            result = Math.max(result, map.get(depth));
            pre(root.left, depth);
            pre(root.right, depth);
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
