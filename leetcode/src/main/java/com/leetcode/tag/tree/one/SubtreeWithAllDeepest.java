package com.leetcode.tag.tree.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 865. 具有所有最深结点的最小子树
 * <p>
 * 没有搞懂题目
 * <p>
 * 没有搞懂题目
 * <p>
 * 没有搞懂题目
 */
public class SubtreeWithAllDeepest {
    class Solution {
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            return null;
        }
    }

    /**
     * 方法一： 两次深度优先搜索
     * <p>
     * 先做一次深度优先搜索标记所有节点的深度来找到最深的节点，再做一次深度优先搜索用回溯法找最小子树
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes/solution/ju-you-suo-you-zui-shen-jie-dian-de-zui-xiao-zi-sh/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        Map<TreeNode, Integer> depth;
        int max_depth;

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            depth = new HashMap<>(64);
            depth.put(null, -1);
            dfs(root, null);

            //最大深度
            max_depth = -1;
            for (Integer d : depth.values()) {
                max_depth = Math.max(max_depth, d);
            }

            return answer(root);
        }

        /**
         * 标记所有结点的深度
         * <p>
         * 先序遍历
         * <p>
         * 后序遍历更好
         * <p>
         * 深度为parent+1
         *
         * @param node
         * @param parent
         */
        public void dfs(TreeNode node, TreeNode parent) {
            if (node == null) {
                return;
            }
            depth.put(node, depth.get(parent) + 1);
            dfs(node.left, node);
            dfs(node.right, node);
        }

        /**
         * 后序遍历
         *
         * @param node
         * @return
         */
        public TreeNode answer(TreeNode node) {
            if (node == null || depth.get(node) == max_depth) {
                return node;
            }
            TreeNode l = answer(node.left);
            TreeNode r = answer(node.right);
            //left和right都不为null
            if (l != null && r != null) {
                return node;
            }
            //left和right有一个为null
            return l != null ? l : r;
        }
    }

    /**
     * 方法二： 一次深度优先搜索
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes/solution/ju-you-suo-you-zui-shen-jie-dian-de-zui-xiao-zi-sh/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            return dfs(root).node;
        }

        // Return the result of the subtree at this node.
        public Result dfs(TreeNode node) {
            if (node == null) {
                return new Result(null, 0);
            }
            Result L = dfs(node.left);
            Result R = dfs(node.right);
            //如果只有一个 childResult 具有最深节点，返回 childResult.node
            if (L.dist > R.dist) {
                return new Result(L.node, L.dist + 1);
            }
            if (L.dist < R.dist) {
                return new Result(R.node, R.dist + 1);
            }
            //如果两个孩子都有最深节点，返回 node
            return new Result(node, L.dist + 1);
        }
    }

    /**
     * 封装数据结构
     * <p>
     * The result of a subtree is:
     * Result.node: the largest depth node that is equal to or
     * an ancestor of all the deepest nodes of this subtree.
     * Result.dist: the number of nodes in the path from the root
     * of this subtree, to the deepest node in this subtree.
     */
    class Result {
        TreeNode node;
        int dist;

        Result(TreeNode n, int d) {
            node = n;
            dist = d;
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
