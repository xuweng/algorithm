package com.leetcode.tag.tree.three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 653. 两数之和 IV - 输入 BST
 */
public class FindTarget {
    class Solution {
        List<Integer> list = new ArrayList<>();

        public boolean findTarget(TreeNode root, int k) {
            zhong(root);

            Set<Integer> set = new HashSet<>(list);

            for (Integer integer : list) {
                if (integer != k - integer && set.contains(k - integer)) {
                    return true;
                }
            }

            return false;
        }

        private void zhong(TreeNode root) {
            if (root == null) {
                return;
            }
            zhong(root.left);
            list.add(root.val);
            zhong(root.right);

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
