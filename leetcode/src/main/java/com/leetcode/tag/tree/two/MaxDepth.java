package com.leetcode.tag.tree.two;

import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 */
public class MaxDepth {
    class Solution {
        public int maxDepth(TreeNode root) {
            return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    /**
     * 方法二：层序遍历（BFS）
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/solution/mian-shi-ti-55-i-er-cha-shu-de-shen-du-xian-xu-bia/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 每遍历一层，则计数器 +1 ，直到遍历完成，则可得到树的深度
         *
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            List<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            List<TreeNode> tmp;
            int res = 0;
            while (!queue.isEmpty()) {
                tmp = new LinkedList<>();
                for (TreeNode node : queue) {
                    if (node.left != null) {
                        tmp.add(node.left);
                    }
                    if (node.right != null) {
                        tmp.add(node.right);
                    }
                }
                queue = tmp;
                res++;
            }
            return res;
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
