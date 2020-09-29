package com.leetcode.tag.tree.five;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 04.09. 二叉搜索树序列
 */
public class BSTSequences {
    class Solution {
        public List<List<Integer>> BSTSequences(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> lefts = BSTSequences(root.left);
            List<List<Integer>> rights = BSTSequences(root.right);
            for (List<Integer> left : lefts) {
                for (List<Integer> right : rights) {
                    left.add(0, root.val);
                    left.addAll(right);
                }
            }
            for (List<Integer> right : rights) {
                for (List<Integer> left : lefts) {
                    right.add(0, root.val);
                    right.addAll(left);
                }
            }
            List<List<Integer>> result = new ArrayList<>();
            result.addAll(lefts);
            result.addAll(rights);
            return result;
        }

        private void pre(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            pre(root.left, list);
            pre(root.right, list);
        }

        private void post(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            post(root.left, list);
            post(root.right, list);
            list.add(root.val);
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
