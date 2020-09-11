package com.leetcode.tag.daily.two;

import java.util.*;

/**
 * 216. 组合总和 III
 */
public class CombinationSum3 {
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();
            Deque<Integer> stack = new LinkedList<>();

            back(k, n, 1, result, stack);

            return result;
        }

        private void back(int k, int n, int begin, List<List<Integer>> result, Deque<Integer> stack) {
            if (n < 0) {
                return;
            }
            if (n == 0 && stack.size() == k) {
                result.add(new ArrayList<>(stack));
                return;
            }

            for (int i = begin; i <= 9; i++) {
                if (n - i < 0) {
                    break;
                }
                stack.push(i);
                back(k, n - i, i + 1, result, stack);
                stack.pop();
            }
        }
    }

    static class S {
        public static List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            Deque<Integer> path = new ArrayDeque<>();//存储根节点开始的路径
            dfs3(1, k, path, n, res);
            return res;
        }

        public static void dfs3(int begin, int k, Deque<Integer> path, int target, List<List<Integer>> res) {
            // 1.结束条件
            if (target == 0 && path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }

            // 2.选择列表
            for (int i = begin; i < 10; i++) {
                // 大剪枝
                // 不用递归下一层
                if (target - i < 0) {
                    return;
                }
                // 选择
                path.addLast(i);
                // 递归
                dfs3(i + 1, k, path, target - i, res);
                // 撤销选择
                path.removeLast();
            }
        }
    }
}
