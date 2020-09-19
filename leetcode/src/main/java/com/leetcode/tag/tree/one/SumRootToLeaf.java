package com.leetcode.tag.tree.one;

/**
 * 1022. 从根到叶的二进制数之和
 * <p>
 * 树就是各种遍历。递归树。决策树。
 * <p>
 * 树就是各种遍历。递归树。决策树。
 */
public class SumRootToLeaf {
    class Solution {
        int sum;

        public int sumRootToLeaf(TreeNode root) {
            sum(root, "");

            return sum;
        }

        private void sum(TreeNode root, String temp) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                sum += Integer.parseUnsignedInt(temp + root.val, 2);
                return;
            }

            sum(root.left, temp + root.val);
            sum(root.right, temp + root.val);
        }
    }

    /**
     * 作者：zui-weng-jiu-xian
     * 链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/solution/jie-jin-shuang-bai-cong-gen-dao-xie-de-er-jin-zhi-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * }
     */
    class Solution1 {
        int ans = 0;    // 存放结果
        int mod = 1000000000 + 7;   // 用作取模

        public int sumRootToLeaf(TreeNode root) {
            helper(root, 0);
            return ans % mod;
        }

        public void helper(TreeNode root, int sum) {
            if (root == null) {
                return;
            }
            sum = sum * 2 + root.val;
            if (root.left == null && root.right == null) {
                ans += sum;     // 到达叶子节点，得到一个和，加到结果上
            } else {    // 没有到达叶子节点，继续递归
                helper(root.left, sum);
                helper(root.right, sum);
            }
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
