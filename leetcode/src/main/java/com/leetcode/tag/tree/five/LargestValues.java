package com.leetcode.tag.tree.five;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 515. 在每个树行中找最大值
 */
public class LargestValues {
    class Solution {
        long[] maxLevel;

        public List<Integer> largestValues(TreeNode root) {
            maxLevel = new long[10000];
            Arrays.fill(maxLevel, Long.MIN_VALUE);

            preorder(root, 1);

            return Arrays.stream(maxLevel).filter(i -> i != Long.MIN_VALUE).mapToInt(i -> (int) i).boxed().collect(Collectors.toList());
        }

        private void preorder(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            maxLevel[level] = Math.max(root.val, maxLevel[level]);
            preorder(root.left, level + 1);
            preorder(root.right, level + 1);
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
