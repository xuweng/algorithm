package com.leetcode.tag.dfs.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 III
 */
public class Rob {
    class Solution {
        Map<TreeNode, Integer> memo = new HashMap<>();

        public int rob(TreeNode root) {
            if (memo.containsKey(root)) {
                return memo.get(root);
            }
            if (root == null) {
                return 0;
            }
            int left = 0;
            int right = 0;
            int cur = root.val;
            if (root.left != null) {
                left = rob(root.left);
                cur += rob(root.left.left);
                cur += rob(root.left.right);
            }
            if (root.right != null) {
                right = rob(root.right);
                cur += rob(root.right.left);
                cur += rob(root.right.right);
            }
            memo.put(root, Math.max(cur, left + right));

            return memo.get(root);
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
