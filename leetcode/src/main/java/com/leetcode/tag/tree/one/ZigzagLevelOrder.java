package com.leetcode.tag.tree.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层次遍历
 */
public class ZigzagLevelOrder {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<List<Integer>> result = new ArrayList<>();
            ceng(root, result, 0);

            for (int i = 0; i < result.size(); i++) {
                if (i % 2 != 0) {
                    Collections.reverse(result.get(i));
                }
            }

            return result;
        }

        private void ceng(TreeNode root, List<List<Integer>> result, int high) {
            if (root == null) {
                return;
            }
            if (high == result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(high).add(root.val);
            ceng(root.left, result, high + 1);
            ceng(root.right, result, high + 1);
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
