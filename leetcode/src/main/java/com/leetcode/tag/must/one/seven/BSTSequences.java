package com.leetcode.tag.must.one.seven;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 04.09. 二叉搜索树序列
 */
public class BSTSequences {
    class Solution {
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> BSTSequences(TreeNode root) {
            List<TreeNode> wait = new ArrayList<>();
            if (root != null) {
                wait.add(root);
            }
            backtrack(wait, new ArrayList<>());
            return res;
        }

        private void backtrack(List<TreeNode> wait, List<Integer> curList) {
            if (wait.size() == 0) {
                res.add(new ArrayList<>(curList));
                return;
            }
            int size = wait.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = wait.remove(0);
                curList.add(cur.val);
                if (cur.left != null) {
                    wait.add(cur.left);
                }
                if (cur.right != null) {
                    wait.add(cur.right);
                }
                backtrack(wait, curList);
                curList.remove(curList.size() - 1);
                if (cur.left != null) {
                    wait.remove(wait.size() - 1);
                }
                if (cur.right != null) {
                    wait.remove(wait.size() - 1);
                }
                wait.add(cur);
            }
        }
    }

    /**
     * 作者：dong-men
     * 链接：https://leetcode-cn.com/problems/bst-sequences-lcci/solution/pei-tu-hui-su-mo-ban-xiang-xi-zhu-shi-by-dong-men/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        // 这两个声明成全局变量，这也回溯函数就少传点参数
        // 维护一个path用来保存路径
        private LinkedList<Integer> path = new LinkedList<>();
        private List<List<Integer>> result = new LinkedList<>();

        public List<List<Integer>> BSTSequences(TreeNode root) {
            //额外维护一个候选节点队列dq
            Deque<TreeNode> dq = new LinkedList<>();
            if (root != null) {
                dq.offer(root);
            }
            dfs(dq);
            return result;
        }

        // 1.确定递归函数返回值和参数
        public void dfs(Deque<TreeNode> dq) {
            // 2.确定递归终止条件
            // dq是该层剩下可选节点的候选队列，若队列为空，则说明没有候选元素了
            // 因此可直接把当前路径添加到结果集，然后返回
            if (dq.isEmpty()) {
                result.add(new ArrayList<>(path));
                return;
            }

            //3.确定回溯函数的遍历过程
            while (!dq.isEmpty()) {
                TreeNode cur = dq.pollFirst();
                // 向路径中添加当前值
                path.add(cur.val);
                // 记录添加的子节点数量，等会回溯时需要用
                int children = 0;
                // 向候选队列中添加子节点
                if (cur.left != null) {
                    children++;
                    dq.offerLast(cur.left);
                }
                if (cur.right != null) {
                    children++;
                    dq.offerLast(cur.right);
                }

                // 递归
                dfs(dq);

                // 回溯候选队列
                while (children > 0) {
                    dq.pollLast();
                    children--;
                }
                dq.offerLast(cur);

                // 回溯路径
                path.removeLast();
            }
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
