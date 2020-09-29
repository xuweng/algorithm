package com.leetcode.tag.tree.four;

/**
 * 1008. 先序遍历构造二叉树
 * <p>
 * 小结果集排查问题
 */
public class BstFromPreorder {
    class Solution {
        public TreeNode bstFromPreorder(int[] preorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            return bstFromPreorder(preorder, 0, preorder.length - 1);
        }

        public TreeNode bstFromPreorder(int[] preorder, int low, int high) {
            //必须
            if (low > high) {
                return null;
            }
            //必须
            if (low == high) {
                return new TreeNode(preorder[low]);
            }
            int index = 0;
            for (int i = low + 1; i <= high; i++) {
                if (preorder[i] > preorder[low]) {
                    index = i;
                    break;
                }
            }
            TreeNode root = new TreeNode(preorder[low]);
            //注意下标计算
            root.left = bstFromPreorder(preorder, low + 1, index - 1);
            root.right = bstFromPreorder(preorder, index, high);
            return root;
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
