package com.leetcode.tag.daily.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 */
public class LevelOrderBottom {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            hou(root, 0);

            Collections.reverse(result);

            return result;
        }

        private void hou(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (result.size() == level) {
                result.add(new ArrayList<>());
            }
            hou(root.left, level + 1);
            hou(root.right, level + 1);

            result.get(level).add(root.val);
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
