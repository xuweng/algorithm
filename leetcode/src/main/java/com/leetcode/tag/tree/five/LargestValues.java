package com.leetcode.tag.tree.five;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 515. 在每个树行中找最大值
 */
public class LargestValues {
    class Solution {
        int[] maxLevel;

        public List<Integer> largestValues(TreeNode root) {
            maxLevel = new int[10000];
            Arrays.fill(maxLevel, Integer.MIN_VALUE);

            return Arrays.stream(maxLevel).filter(i -> i != Integer.MIN_VALUE).boxed().collect(Collectors.toList());
        }

        private void preorder(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            maxLevel[level] = Math.max(root.val, maxLevel[level]);
            preorder(root.left, level);
            preorder(root.right, level);
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
