package com.leetcode.tag.daily.two;

import java.util.*;

/**
 * 107. 二叉树的层次遍历 II
 */
public class LevelOrderBottom {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            hou(root, 0);

            Collections.reverse(result);

            return result;
        }

        private void hou(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (result.size() == level) {
                result.add(new ArrayList<>());
            }
            hou(root.left, level + 1);
            hou(root.right, level + 1);

            result.get(level).add(root.val);
        }
    }

    /**
     * 方法一：广度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/solution/er-cha-shu-de-ceng-ci-bian-li-ii-by-leetcode-solut/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> levelOrder = new LinkedList<>();
            if (root == null) {
                return levelOrder;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    TreeNode left = node.left, right = node.right;
                    //入队
                    if (left != null) {
                        queue.offer(left);
                    }
                    //入队
                    if (right != null) {
                        queue.offer(right);
                    }
                }
                levelOrder.add(0, level);
            }
            return levelOrder;
        }
    }

    /**
     * dfs
     */
    class Solution2 {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            dfs(root, 0, res);
            return res;
        }

        public void dfs(TreeNode node, int depth, List<List<Integer>> res) {
            if (node == null) {
                return;
            }
            if (depth == res.size()) {
                res.add(0, new ArrayList<>());
            }
            res.get(res.size() - depth - 1).add(node.val);
            dfs(node.left, depth + 1, res);
            dfs(node.right, depth + 1, res);
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
