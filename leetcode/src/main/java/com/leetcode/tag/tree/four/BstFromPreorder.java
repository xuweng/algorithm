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
            //查找right的下标.如果没有right.right为null.只有root->left.high属于left.
            //这个初始化厉害
            int index = high + 1;
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

    /**
     * 简洁代码
     */
    class S {
        public TreeNode bstFromPreorder(int[] preorder) {
            return bstDfs(preorder, 0, preorder.length - 1);
        }

        private TreeNode bstDfs(int[] preorder, int start, int end) {
            if (start > end) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[start]);
            //简洁代码
            int index = start + 1;
            while (index <= end) {
                if (preorder[index] > root.val) {
                    break;
                }
                index++;
            }
            root.left = bstDfs(preorder, start + 1, index - 1);
            root.right = bstDfs(preorder, index, end);
            return root;
        }
    }

    /**
     * 简洁代码
     */
    class Solution2 {
        public TreeNode bstFromPreorder(int[] preorder) {
            return build(preorder, 0, preorder.length - 1);
        }

        private TreeNode build(int[] preorder, int l, int r) {
            if (l > r) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[l]);
            int index = l + 1;
            while (index <= r && preorder[index] < preorder[l]) {
                index++;
            }
            root.left = build(preorder, l + 1, index - 1);
            root.right = build(preorder, index, r);

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
