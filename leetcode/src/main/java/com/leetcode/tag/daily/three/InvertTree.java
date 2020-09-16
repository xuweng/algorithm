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
        /**
         * 如果当前遍历到的节点 root 的左右两棵子树都已经翻转，那么我们只需要交换两棵子树的位置，即可完成以 root 为根节点的整棵子树的翻转
         * <p>
         * 作者：LeetCode-Solution
         * 链接：https://leetcode-cn.com/problems/invert-binary-tree/solution/fan-zhuan-er-cha-shu-by-leetcode-solution/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param root
         * @return
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            //交换两棵子树的位置
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
