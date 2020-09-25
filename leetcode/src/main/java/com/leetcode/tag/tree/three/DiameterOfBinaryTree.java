package com.leetcode.tag.tree.three;

/**
 * 543. 二叉树的直径
 */
public class DiameterOfBinaryTree {
    /**
     * 算法错误
     */
    class Solution {
        int max;

        public int diameterOfBinaryTree(TreeNode root) {
            diameterOfBinaryTree1(root);

            return max - 1;
        }

        public int diameterOfBinaryTree1(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int result = diameterOfBinaryTree1(root.left) + diameterOfBinaryTree1(root.right) + 1;
            max = Math.max(max, result);
            //返回错误
            return result;
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/er-cha-shu-de-zhi-jing-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int ans;

        public int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            depth(root);
            return ans - 1;
        }

        public int depth(TreeNode node) {
            if (node == null) {
                // 访问到空节点了，返回0
                return 0;
            }
            // 左儿子为根的子树的深度
            int L = depth(node.left);
            // 右儿子为根的子树的深度
            int R = depth(node.right);
            // 计算d_node即L+R+1 并更新ans
            ans = Math.max(ans, L + R + 1);
            // 返回该节点为根的子树的深度
            return Math.max(L, R) + 1;
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
