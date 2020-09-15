package com.leetcode.tag.tree.two;

/**
 * 1339. 分裂二叉树的最大乘积
 * <p>
 * 遍历
 * <p>
 * 直接看题解学习
 */
public class MaxProduct {
    /**
     * 要求两棵子树和的最大乘积，那就得先求出两棵子树各自的和。
     * 分别求两棵子树的和显然很难做到，但我们可以很方便的其中一个子树的和。
     * 用整棵树的总和 减去求出的子树和，就得到了另一棵子树和。
     * 枚举所有子树，对乘积取最大。
     * <p>
     * 作者：huwt
     * 链接：https://leetcode-cn.com/problems/maximum-product-of-splitted-binary-tree/solution/fen-lie-er-cha-shu-de-zui-da-cheng-ji-ti-jie-by-hu/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int maxProduct(TreeNode root) {
            return 0;
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
