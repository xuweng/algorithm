package com.leetcode.tag.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 */
public class KthLargest {
    class Solution {
        /**
         * 1 ≤ k ≤ 二叉搜索树元素个数
         *
         * @param root
         * @param k
         * @return
         */
        public int kthLargest(TreeNode root, int k) {
            List<Integer> result = new ArrayList<>();

            zhong(result, root);

            return result.get(result.size() - k);
        }

        private void zhong(List<Integer> result, TreeNode root) {
            if (root == null) {
                return;
            }
            zhong(result, root.left);
            result.add(root.val);
            zhong(result, root.right);
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
