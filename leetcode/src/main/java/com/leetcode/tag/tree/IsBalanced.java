package com.leetcode.tag.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 * <p>
 * 不用做晦涩题目。直接看题解。
 * <p>
 * 任意节点的左右子树的深度相差不超过1
 * <p>
 * 任意结点。递归定义。
 * <p>
 * 后序遍历
 * <p>
 * 大脑执行一遍代码
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
     * 后序遍历。获取递归结果。
     * <p>
     * 学习这种递归
     * <p>
     * 这种递归。这种递归。
     * <p>
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

        /**
         * 肯定需要遍历
         * <p>
         * 已经后序遍历
         * <p>
         * 思路是对二叉树做后序遍历，从底至顶返回子树深度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回。
         *
         * @param root
         * @return
         */
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
            //满足条件则返回深度，否则返回-1
            return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
        }
    }

    /**
     * 产生大量重复计算。相当二重循环遍历。重复计算底层结点。
     * <p>
     * 方法二：先序遍历 + 判断深度 （从顶至底）
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/solution/mian-shi-ti-55-ii-ping-heng-er-cha-shu-cong-di-zhi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int depth(TreeNode root) {
            return root == null ? 0 : Math.max(depth(root.left), depth(root.right)) + 1;
        }
    }

    class S {
        // 存在大量的重复计算 depth
        // 额外使用一个 HashMap 来避免重复计算
        Map<TreeNode, Integer> map = new HashMap<>();

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            // 对每棵子树递归检查是否平衡
            return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        // 获取树的最大深度
        public int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (map.containsKey(root)) {
                return map.get(root);
            }
            int curDepth = Math.max(depth(root.left), depth(root.right)) + 1;
            map.put(root, curDepth);
            return curDepth;

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
