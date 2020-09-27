package com.leetcode.tag.tree.four;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历.
 * <p>
 * 变成一颗tree后用bsf.
 */
public class PostorderTraversal {
    class Solution {
        List<Integer> result = new ArrayList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            post(root);

            return result;
        }

        private void post(TreeNode root) {
            if (root == null) {
                return;
            }
            post(root.left);
            post(root.right);
            result.add(root.val);
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
