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

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
