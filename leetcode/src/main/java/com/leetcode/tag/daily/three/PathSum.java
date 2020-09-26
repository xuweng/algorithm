package com.leetcode.tag.daily.three;

import java.util.*;

/**
 * 113. 路径总和 II
 */
public class PathSum {
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new ArrayList<>();
            Deque<Integer> stack = new LinkedList<>();

            pre(root, sum, result, stack);

            return result;
        }

        /**
         * root.val和sum可能是负数
         *
         * @param root
         * @param sum
         * @param result
         * @param stack
         */
        private void pre(TreeNode root, int sum, List<List<Integer>> result, Deque<Integer> stack) {
            if (root == null) {
                return;
            }
            //叶子结点
            if (root.left == null && root.right == null && sum == root.val) {
                stack.push(root.val);
                List<Integer> list = new ArrayList<>(stack);
                Collections.reverse(list);
                result.add(list);
                stack.pop();
                return;
            }
            stack.push(root.val);
            pre(root.left, sum - root.val, result, stack);
            stack.pop();

            stack.push(root.val);
            pre(root.right, sum - root.val, result, stack);
            stack.pop();
        }
    }

    /**
     * dfs
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/path-sum-ii/solution/lu-jing-zong-he-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        List<List<Integer>> ret = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            dfs(root, sum);
            return ret;
        }

        public void dfs(TreeNode root, int sum) {
            if (root == null) {
                return;
            }
            path.offerLast(root.val);
            sum -= root.val;
            //这个条件一样
            if (root.left == null && root.right == null && sum == 0) {
                ret.add(new LinkedList<>(path));
            }
            dfs(root.left, sum);
            dfs(root.right, sum);
            path.pollLast();
        }
    }

    /**
     * bfs
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/path-sum-ii/solution/lu-jing-zong-he-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        List<List<Integer>> ret = new LinkedList<>();
        //使用哈希表记录树中的每一个节点的父节点
        Map<TreeNode, TreeNode> map = new HashMap<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root == null) {
                return ret;
            }

            //bfs的队列
            Queue<TreeNode> queueNode = new LinkedList<>();
            //保存路径和
            Queue<Integer> queueSum = new LinkedList<>();
            queueNode.offer(root);
            queueSum.offer(0);

            while (!queueNode.isEmpty()) {
                TreeNode node = queueNode.poll();
                int rec = queueSum.poll() + node.val;

                if (node.left == null && node.right == null) {
                    if (rec == sum) {
                        getPath(node);
                    }
                } else {
                    if (node.left != null) {
                        //key是结点.value是父节点
                        map.put(node.left, node);
                        queueNode.offer(node.left);
                        queueSum.offer(rec);
                    }
                    if (node.right != null) {
                        //key是结点.value是父节点
                        map.put(node.right, node);
                        queueNode.offer(node.right);
                        queueSum.offer(rec);
                    }
                }
            }

            return ret;
        }

        /**
         * 每次找到一个满足条件的节点，我们就从该节点出发不断向父节点迭代，即可还原出从根节点到当前节点的路径
         *
         * @param node
         */
        public void getPath(TreeNode node) {
            List<Integer> temp = new LinkedList<>();
            while (node != null) {
                temp.add(node.val);
                node = map.get(node);
            }
            Collections.reverse(temp);
            ret.add(new LinkedList<>(temp));
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
