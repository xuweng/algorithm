package com.leetcode.tag.tree.two;

/**
 * 979. 在二叉树中分配硬币
 * <p>
 * 反序。反序。反序。反序
 */
public class DistributeCoins {
    /**
     * 方法：深度优先搜索
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/distribute-coins-in-binary-tree/solution/zai-er-cha-shu-zhong-fen-pei-ying-bi-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        int ans;

        public int distributeCoins(TreeNode root) {
            ans = 0;
            dfs(root);
            return ans;
        }

        public int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int L = dfs(node.left);
            int R = dfs(node.right);
            ans += Math.abs(L) + Math.abs(R);
            return node.val + L + R - 1;
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
