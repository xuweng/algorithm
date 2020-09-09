package com.leetcode.tag.daily.two;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * <p>
 * 递归树
 * <p>
 * 递归树
 * <p>
 * 候选集动态改变
 */
public class CombinationSum {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Deque<Integer> stack = new LinkedList<>();

            back(candidates, target, 0, 0, result, stack);

            return result;
        }

        /**
         * 数据重复
         * <p>
         * 解集不能包含重复的组合
         *
         * @param candidates
         * @param target
         * @param sum
         * @param result
         * @param stack
         */
        private void back(int[] candidates, int target, int start, int sum, List<List<Integer>> result, Deque<Integer> stack) {
            if (sum == target) {
                result.add(new ArrayList<>(stack));
                return;
            }
            if (sum > target) {
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                int candidate = candidates[i];
                //选择i
                stack.push(candidate);
                //这样不能重复选择i
                back(candidates, target, i + 1, sum + candidate, result, stack);
                stack.pop();
            }
        }
    }

    /**
     * 方法一：搜索回溯
     * <p>
     * 可以选择跳过不用第 idx 个数
     * <p>
     * 也可以选择使用第 idx 个数
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/combination-sum/solution/zu-he-zong-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> combine = new ArrayList<>();
            dfs(candidates, target, ans, combine, 0);
            return ans;
        }

        /**
         * 不会倒退选择就不会重复.顺序选择。
         *
         * @param candidates
         * @param target
         * @param ans
         * @param combine
         * @param idx
         */
        public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
            if (idx == candidates.length) {
                return;
            }
            if (target == 0) {
                ans.add(new ArrayList<>(combine));
                return;
            }
            // 直接跳过。idx+1.
            dfs(candidates, target, ans, combine, idx + 1);
            // 即使选择当前数，idx也不变
            // 选择当前数
            if (target - candidates[idx] >= 0) {
                combine.add(candidates[idx]);
                //idx不变
                //注意到每个数字可以被无限制重复选取，因此搜索的下标仍为 idx
                dfs(candidates, target - candidates[idx], ans, combine, idx);
                combine.remove(combine.size() - 1);
            }
        }
    }

}
