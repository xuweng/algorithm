package com.leetcode.tag.tree.four;

/**
 * 129. 求根到叶子节点数字之和
 */
public class SumNumbers {
    class Solution {
        int result;

        public int sumNumbers(TreeNode root) {
            pre(root, "");

            return result;
        }

        private void pre(TreeNode root, String temp) {
            if (root == null) {
                return;
            }
            //在叶子结点计算
            if (root.left == null && root.right == null) {
                result += Integer.parseInt(temp + root.val);
                return;
            }
            pre(root.left, temp + root.val);
            pre(root.right, temp + root.val);
        }
    }

    /**
     * 作者：liuzhaoce
     * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/0-ms-jiao-ke-shu-ji-jie-da-by-liuzhaoce/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int sumNumbers(TreeNode root) {
            return helper(root, 0);
        }

        public int helper(TreeNode root, int i) {
            if (root == null) {
                return 0;
            }
            //这个计算厉害
            int temp = i * 10 + root.val;
            if (root.left == null && root.right == null) {
                return temp;
            }
            return helper(root.left, temp) + helper(root.right, temp);
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
