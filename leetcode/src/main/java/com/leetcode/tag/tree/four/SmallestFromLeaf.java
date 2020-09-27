package com.leetcode.tag.tree.four;

/**
 * 988. 从叶结点开始的最小字符串
 */
public class SmallestFromLeaf {
    class Solution {
        public String smallestFromLeaf(TreeNode root) {
            String str = hou(root);

            StringBuilder result = new StringBuilder();
            for (char c : str.toCharArray()) {
                result.append((c + 97));
            }
            return result.toString();
        }

        public String hou(TreeNode root) {
            if (root == null) {
                return "";
            }
            String left = hou(root.left);
            String right = hou(root.right);

            return left.compareTo(right) <= 0 ? left + root.val : right + root.val;
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
