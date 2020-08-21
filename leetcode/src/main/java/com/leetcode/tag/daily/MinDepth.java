package com.leetcode.tag.daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 */
public class MinDepth {
    class Solution {
        int result = Integer.MAX_VALUE;

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            pre(root, 1);
            return result;
        }

        public void pre(TreeNode treeNode, int count) {
            if (treeNode == null) {
                return;
            }
            if (treeNode.left == null && treeNode.right == null) {
                result = Math.min(result, count);
                return;
            }
            count = count + 1;
            if (treeNode.left != null) {
                pre(treeNode.left, count);
            }
            if (treeNode.right != null) {
                pre(treeNode.right, count);
            }
        }
    }

    /**
     * 方法一：深度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/er-cha-shu-de-zui-xiao-shen-du-by-leetcode-solutio/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null) {
                return 1;
            }

            int minDepth = Integer.MAX_VALUE;
            if (root.left != null) {
                minDepth = Math.min(minDepth(root.left), minDepth);
            }
            if (root.right != null) {
                minDepth = Math.min(minDepth(root.right), minDepth);
            }

            return minDepth + 1;
        }
    }

    /**
     * 方法二：广度优先搜索
     */
    class Solution2 {
        class QueueNode {
            TreeNode node;
            //记录每个结点的高度
            int depth;

            public QueueNode(TreeNode node, int depth) {
                this.node = node;
                this.depth = depth;
            }
        }

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<QueueNode> queue = new LinkedList<>();
            queue.offer(new QueueNode(root, 1));
            while (!queue.isEmpty()) {
                QueueNode nodeDepth = queue.poll();
                TreeNode node = nodeDepth.node;
                int depth = nodeDepth.depth;
                //当我们找到一个叶子节点时，直接返回这个叶子节点的深度。广度优先搜索的性质保证了最先搜索到的叶子节点的深度一定最小。
                if (node.left == null && node.right == null) {
                    return depth;
                }
                //模板
                if (node.left != null) {
                    queue.offer(new QueueNode(node.left, depth + 1));
                }
                //模板
                if (node.right != null) {
                    queue.offer(new QueueNode(node.right, depth + 1));
                }
            }

            return 0;
        }
    }

    /**
     * 作者：reals
     * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/li-jie-zhe-dao-ti-de-jie-shu-tiao-jian-by-user7208/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int m1 = minDepth(root.left);
            int m2 = minDepth(root.right);
            //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1。m1和m2有一个为0。
            //2.如果都不为空，返回较小深度+1
            return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1, m2) + 1;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
