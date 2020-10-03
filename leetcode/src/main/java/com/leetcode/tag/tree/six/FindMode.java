package com.leetcode.tag.tree.six;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 */
public class FindMode {
    class Solution {
        TreeNode pre;
        int max;
        int count;
        List<Integer> list = new ArrayList<>();

        public int[] findMode(TreeNode root) {
            inorder(root);

            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);

            if (pre != null) {
                count = pre.val == root.val ? ++count : 0;
                if (count > max) {
                    list.clear();
                    max = count;
                }
            }
            list.add(root.val);
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
