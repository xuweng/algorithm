package com.leetcode.tag.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 */
public class KthLargest {
    class Solution {
        /**
         * 1 ≤ k ≤ 二叉搜索树元素个数
         *
         * @param root
         * @param k
         * @return
         */
        public int kthLargest(TreeNode root, int k) {
            List<Integer> result = new ArrayList<>();

            zhong(result, root);

            return result.get(result.size() - k);
        }

        private void zhong(List<Integer> result, TreeNode root) {
            if (root == null) {
                return;
            }
            zhong(result, root.left);
            result.add(root.val);
            zhong(result, root.right);
        }

    }

    /**
     * 求 “二叉搜索树第 k 大的节点” 可转化为求 “此树的中序遍历倒序的第 k 个节点”。
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/mian-shi-ti-54-er-cha-sou-suo-shu-de-di-k-da-jie-d/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int res, k;

        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res;
        }

        void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.right);
            if (k == 0) {
                return;
            }
            if (--k == 0) {
                res = root.val;
            }
            dfs(root.left);
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
