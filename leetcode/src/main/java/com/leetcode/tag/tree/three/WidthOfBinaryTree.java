package com.leetcode.tag.tree.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 662. 二叉树最大宽度
 * <p>
 * 十分钟看题解.有些测试用例是一个坑.
 */
public class WidthOfBinaryTree {
    class Solution {
        List<List<Integer>> lists = new ArrayList<>();

        public int widthOfBinaryTree(TreeNode root) {
            pre(root, 0);
            int result = 0;
            for (List<Integer> list : lists) {
                if (list.size() > 1 && list.get(0) != null && list.get(list.size() - 1) != null) {
                    result = Math.max(result, list.size());
                }
            }
            return result;

        }

        private void pre(TreeNode root, int level) {
            if (root == null) {
                if (level < lists.size() && lists.get(level) != null) {
                    lists.get(level).add(null);
                }
                return;
            }
            if (lists.size() == level) {
                lists.add(new ArrayList<>());
            }
            lists.get(level).add(root.val);
            pre(root.left, level + 1);
            pre(root.right, level + 1);
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
