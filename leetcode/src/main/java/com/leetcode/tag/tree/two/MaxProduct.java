package com.leetcode.tag.tree.two;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 后序遍历得到分别以各个节点为根的子树总和
     * 去掉一条边的乘积 = 子树总和 * （总和 - 子树总和），取最大值
     * 不能提前取模。比如 1e9 + 7（取模后为0） 和 1e9 + 6（取模后不变），提前取模会导致错误
     * <p>
     * 后序遍历
     * <p>
     * 作者：hypogump-2
     * 链接：https://leetcode-cn.com/problems/maximum-product-of-splitted-binary-tree/solution/c-hou-xu-bian-li-by-hypogump-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<Long> sums = new ArrayList<>();
        double mod = 1e9 + 7;

        int maxProduct(TreeNode root) {
            postOrder(root);

            long res = -1;
            for (int i = 0; i < sums.size() - 1; ++i) {
                // 取最大值时不能取模，应该用long型存结果
                res = Math.max(res, sums.get(i) * (sums.get(sums.size() - 1) - sums.get(i)));
            }
            return (int) (res % mod);
        }

        /**
         * 后序遍历
         *
         * @param root
         * @return
         */
        long postOrder(TreeNode root) {
            if (root == null) {
                return 0;
            }
            long res = postOrder(root.left) + postOrder(root.right) + root.val;
            sums.add(res);
            return res;
        }
    }

    ;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
