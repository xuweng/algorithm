package com.leetcode.tag.tree.five;

/**
 * 面试题 04.06. 后继者
 */
public class InorderSuccessor {
    class Solution {
        int index;
        int pIndex = -1;
        TreeNode result;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            inorder(root, p);

            return result;
        }

        /**
         * 中序遍历不要搞错位置
         *
         * @param root
         * @param p
         */
        public void inorder(TreeNode root, TreeNode p) {
            if (root == null) {
                return;
            }

            inorder(root.left, p);
            index++;
            if (root == p) {
                pIndex = index;
            }
            if (index == pIndex + 1) {
                result = root;
                return;
            }
            inorder(root.right, p);
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
