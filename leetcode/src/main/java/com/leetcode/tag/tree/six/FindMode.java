package com.leetcode.tag.tree.six;

import java.util.HashSet;
import java.util.Set;

/**
 * 501. 二叉搜索树中的众数
 */
public class FindMode {
    class Solution {
        TreeNode pre;
        int max;
        int count;
        Set<Integer> set = new HashSet<>();

        public int[] findMode(TreeNode root) {
            inorder(root);

            return set.stream().mapToInt(Integer::intValue).toArray();
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);

            if (pre != null) {
                count = pre.val == root.val ? ++count : 0;
                if (count > max) {
                    set.clear();
                    max = count;
                }
            }
            set.add(root.val);
            pre = root;

            inorder(root.right);
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
