package com.leetcode.tag.tree.five;

/**
 * 124. 二叉树中的最大路径和
 */
public class MaxPathSum {
    class Solution {
        //注意初始化
        int result = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);

            return result;
        }

        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            left = Math.max(left, 0);
            int right = dfs(root.right);
            right = Math.max(right, 0);

            result = Math.max(result, root.val + left + right);

            return Math.max(left, right) + root.val;
        }
    }

    /**
     * dfs
     * <p>
     * 简洁代码
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return maxSum;
        }

        public int maxGain(TreeNode node) {
            if (node == null) {
                return 0;
            }

            // 递归计算左右子节点的最大贡献值
            // 只有在最大贡献值大于 0 时，才会选取对应子节点
            int leftGain = Math.max(maxGain(node.left), 0);
            int rightGain = Math.max(maxGain(node.right), 0);

            maxSum = Math.max(maxSum, node.val + leftGain + rightGain);

            // 返回节点的最大贡献值
            return node.val + Math.max(leftGain, rightGain);
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
