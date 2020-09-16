package com.leetcode.tag.daily.three;

/**
 * 226. 翻转二叉树
 * <p>
 * 直接看题解
 * <p>
 * 直接看题解
 * <p>
 * 直接看题解
 */
public class InvertTree {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            return invert(root, root);
        }

        /**
         * 都是一颗tree
         * <p>
         * 这样会改变tree的数据,导致后面的赋值错误
         *
         * @param root
         * @param root1
         */
        private TreeNode invert(TreeNode root, TreeNode root1) {
            if (root == null) {
                return root1;
            }
            if (root1 == null) {
                return null;
            }
            TreeNode treeNode = new TreeNode(root1.val);
            treeNode.left = invert(root.left, root1.right);
            treeNode.right = invert(root.right, root1.left);

            return treeNode;
        }
    }

    /**
     * 方法一：递归
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/invert-binary-tree/solution/fan-zhuan-er-cha-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;
            return root;
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
