package com.leetcode.tag.tree.two;

/**
 * 968. 监控二叉树
 * <p>
 * 这种题一开始就看题解
 * <p>
 * 没有思路直接看题解学习。
 */
public class MinCameraCover {
    class Solution {
        public int minCameraCover(TreeNode root) {
            return 0;
        }
    }

    /**
     * 方法一：动态规划
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/binary-tree-cameras/solution/jian-kong-er-cha-shu-by-leetcode-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int minCameraCover(TreeNode root) {
            int[] ans = solve(root);
            return Math.min(ans[1], ans[2]);
        }

        /**
         * 返回数组
         *
         * @param node
         * @return
         */
        // 0: Strict ST; All nodes below this are covered, but not this one
        // 1: Normal ST; All nodes below and incl this are covered - no camera
        // 2: Placed camera; All nodes below this are covered, plus camera here
        public int[] solve(TreeNode node) {
            if (node == null) {
                return new int[]{0, 0, 99999};
            }

            int[] L = solve(node.left);
            int[] R = solve(node.right);
            int mL12 = Math.min(L[1], L[2]);
            int mR12 = Math.min(R[1], R[2]);

            int d0 = L[1] + R[1];
            int d1 = Math.min(L[2] + mR12, R[2] + mL12);
            int d2 = 1 + Math.min(L[0], mL12) + Math.min(R[0], mR12);
            return new int[]{d0, d1, d2};
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
