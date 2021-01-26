package com.leetcode.tag.daily.seven;

/**
 * 1457. 二叉树中的伪回文路径
 * <p>
 * 把两个有序整数用一个整数表示，其实是比较常见的「状态压缩」
 */
public class PseudoPalindromicPaths {
    /**
     * 作者：rational-irrationality
     * 链接：https://leetcode-cn.com/problems/pseudo-palindromic-paths-in-a-binary-tree/solution/java-dfs-shuang-bai-by-rational-irrationality/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        int ans = 0;

        public int pseudoPalindromicPaths(TreeNode root) {
            if (root == null) {
                return 0;
            }
            helper(root, 0);

            return ans;
        }

        void helper(TreeNode node, int temp) {
            temp ^= (1 << node.val);//node节点的val为几就左移几位
            if (node.left == null && node.right == null) {//判断是否叶子节点
                if (temp == 0 || (temp & (temp - 1)) == 0) {//判断是否为伪回文
                    ans++;
                }
            }
            if (node.left != null) {
                helper(node.left, temp);
            }
            if (node.right != null) {
                helper(node.right, temp);
            }
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
