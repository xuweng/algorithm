package com.leetcode.tag.tree.five;

import java.util.*;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 */
public class PathSum {
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new ArrayList<>();
            Deque<Integer> stack = new LinkedList<>();

            back(root, sum, result, stack);

            return result;
        }

        private void back(TreeNode root, int sum, List<List<Integer>> result, Deque<Integer> stack) {
            if (root == null) {
                return;
            }
            stack.push(root.val);
            //叶子结点
            if (root.left == null && root.right == null && sum == root.val) {
                List<Integer> list = new ArrayList<>(stack);
                Collections.reverse(list);

                result.add(list);
            }
            back(root.left, sum - root.val, result, stack);
            back(root.right, sum - root.val, result, stack);
            stack.pop();
        }
    }

    /**
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/solution/mian-shi-ti-34-er-cha-shu-zhong-he-wei-mou-yi-zh-5/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        LinkedList<List<Integer>> res = new LinkedList<>();
        //不用deque.
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            recur(root, sum);
            return res;
        }

        void recur(TreeNode root, int tar) {
            if (root == null) {
                return;
            }
            path.add(root.val);
            tar -= root.val;
            if (tar == 0 && root.left == null && root.right == null) {
                res.add(new LinkedList<>(path));
                //如果加了return 会得不到正确的结果。因为代码提前return，导致后面的remove没有执行，影响回溯了
                //return;
            }
            recur(root.left, tar);
            recur(root.right, tar);
            path.removeLast();
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
