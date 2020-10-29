package com.leetcode.tag.daily.four;

/**
 * 129. 求根到叶子节点数字之和
 */
public class SumNumbers {
    class Solution {
        int result;

        public int sumNumbers(TreeNode root) {
            dfs(root, "");
            return result;
        }

        private void dfs(TreeNode root, String temp) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                result += Integer.parseInt(temp + root.val);
                return;
            }
            dfs(root.left, temp + root.val);
            dfs(root.right, temp + root.val);
        }
    }

    /**
     * 方法一：深度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/qiu-gen-dao-xie-zi-jie-dian-shu-zi-zhi-he-by-leetc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int sumNumbers(TreeNode root) {
            return dfs(root, 0);
        }

        public int dfs(TreeNode root, int prevSum) {
            if (root == null) {
                return 0;
            }
            int sum = prevSum * 10 + root.val;
            if (root.left == null && root.right == null) {
                return sum;
            }
            return dfs(root.left, sum) + dfs(root.right, sum);

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
