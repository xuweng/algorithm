package com.leetcode.tag.tree;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 * <p>
 * 不用做晦涩题目。直接看题解。
 * <p>
 * 任意节点的左右子树的深度相差不超过1
 * <p>
 * 任意结点。递归定义。
 */
public class IsBalanced {
    class Solution {
        /**
         * 先序遍历
         *
         * @param root
         * @return
         */
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return is(root) && isBalanced(root.left) && isBalanced(root.right);
        }

        public boolean is(TreeNode root) {
            return root == null || Math.abs(height(root.left) - height(root.right)) <= 1;
        }

        private int height(TreeNode root) {
            return root == null ? 0 : Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    /**
     * 方法一：后序遍历 + 剪枝 （从底至顶）
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/solution/mian-shi-ti-55-ii-ping-heng-er-cha-shu-cong-di-zhi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean isBalanced(TreeNode root) {
            return recur(root) != -1;
        }

        private int recur(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = recur(root.left);
            if (left == -1) {
                return -1;
            }
            int right = recur(root.right);
            if (right == -1) {
                return -1;
            }
            //类似二分。返回-1.
            return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
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
