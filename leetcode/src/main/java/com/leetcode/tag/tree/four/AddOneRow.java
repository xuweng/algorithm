package com.leetcode.tag.tree.four;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 623. 在二叉树中增加一行
 */
public class AddOneRow {
    /**
     * 增加一行会改变原来tree的结构.
     */
    class Solution {
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if (d == 1) {
                TreeNode node = new TreeNode(v);
                node.left = root;
                return node;
            }

            pre(root, v, d, 1);

            return root;
        }

        public void pre(TreeNode root, int v, int d, int depth) {
            if (root == null) {
                return;
            }
            if (depth == d - 1) {
                TreeNode left = root.left;
                TreeNode right = root.right;

                root.left = new TreeNode(v);
                root.right = new TreeNode(v);
                root.left.left = left;
                root.right.right = right;

                //加return需要的时间比不加需要的时间更多.
                return;
            }

            pre(root.left, v, d, depth + 1);
            pre(root.right, v, d, depth + 1);
        }
    }

    /**
     * bfs
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/add-one-row-to-tree/solution/zai-er-cha-shu-zhong-zeng-jia-yi-xing-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public TreeNode addOneRow(TreeNode t, int v, int d) {
            if (d == 1) {
                TreeNode n = new TreeNode(v);
                n.left = t;
                return n;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(t);
            int depth = 1;
            while (!queue.isEmpty() && depth < d - 1) {
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                depth++;
            }
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                TreeNode temp = node.left;
                node.left = new TreeNode(v);
                node.left.left = temp;
                temp = node.right;
                node.right = new TreeNode(v);
                node.right.right = temp;
            }
            return t;
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
