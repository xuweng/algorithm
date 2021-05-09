package com.leetcode.tag.must3.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 */
public class LevelOrder {
    class Solution {
        int index;
        List<Integer> result = new ArrayList<>();

        public int[] levelOrder(TreeNode root) {
            dfs(root);

            return result.stream().mapToInt(integer -> integer).toArray();
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            result.set(index++, root.val);

            dfs(root.left);
            dfs(root.right);
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
