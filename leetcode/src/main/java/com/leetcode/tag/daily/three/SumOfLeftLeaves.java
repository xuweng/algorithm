package com.leetcode.tag.daily.three;

/**
 * 404. 左叶子之和
 */
public class SumOfLeftLeaves {
    class Solution {
        int result;

        public int sumOfLeftLeaves(TreeNode root) {
            pre(root, false);

            return result;
        }

        public void pre(TreeNode root, boolean isLeft) {
            if (root == null) {
                return;
            }
            if (isLeft && root.left == null && root.right == null) {
                result += root.val;
            }
            pre(root.left, true);
            pre(root.right, false);
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves/solution/zuo-xie-zi-zhi-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int sumOfLeftLeaves(TreeNode root) {
            return root != null ? dfs(root) : 0;
        }

        public int dfs(TreeNode node) {
            int ans = 0;
            if (node.left != null) {
                ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
            }
            if (node.right != null && !isLeafNode(node.right)) {
                ans += dfs(node.right);
            }
            return ans;
        }

        public boolean isLeafNode(TreeNode node) {
            return node.left == null && node.right == null;
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
