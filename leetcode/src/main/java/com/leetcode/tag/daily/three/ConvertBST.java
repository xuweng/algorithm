package com.leetcode.tag.daily.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 538. 把二叉搜索树转换为累加树
 */
public class ConvertBST {
    class Solution {
        TreeNode root;
        Map<Integer, Integer> map;

        public TreeNode convertBST(TreeNode root) {
            this.root = root;
            map = new HashMap<>();

            pre(root);
            pre1(root);

            return root;
        }

        private void pre(TreeNode root) {
            if (root == null) {
                return;
            }
            pre(this.root, root.val);
            pre(root.left);
            pre(root.right);
        }

        private void pre1(TreeNode root) {
            if (root == null) {
                return;
            }
            root.val += map.get(root.val);
            pre1(root.left);
            pre1(root.right);
        }

        /**
         * 每次都是遍历原来的tree,会修改原来tree的值
         *
         * @param root
         * @param val
         */
        private void pre(TreeNode root, int val) {
            if (root == null) {
                return;
            }
            if (root.val > val) {
                map.put(val, map.getOrDefault(val, 0) + root.val);
            }
            pre(root.left, val);
            pre(root.right, val);
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
