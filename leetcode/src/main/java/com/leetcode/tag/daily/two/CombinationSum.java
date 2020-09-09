package com.leetcode.tag.daily.two;

import java.util.*;

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

    /**
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            int len = candidates.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }

            Deque<Integer> path = new ArrayDeque<>();
            dfs(candidates, 0, len, target, path, res);
            return res;
        }

        /**
         * 搜索的时候就需要 按某种顺序搜索。具体的做法是：每一次搜索的时候设置 下一轮搜索的起点 begin
         *
         * @param candidates 候选数组
         * @param begin      搜索起点
         * @param len        冗余变量，是 candidates 里的属性，可以不传
         * @param target     每减去一个元素，目标值变小
         * @param path       从根结点到叶子结点的路径，是一个栈
         * @param res        结果集列表
         */
        private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
            // target 为负数和 0 的时候不再产生新的孩子结点
            if (target < 0) {
                return;
            }
            if (target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }

            // 重点理解这里从 begin 开始搜索的语意
            for (int i = begin; i < len; i++) {
                path.addLast(candidates[i]);

                // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
                dfs(candidates, i, len, target - candidates[i], path, res);

                // 状态重置
                path.removeLast();
            }
        }
    }

    /**
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            int len = candidates.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }

            // 排序是剪枝的前提
            Arrays.sort(candidates);

            Deque<Integer> path = new ArrayDeque<>();
            dfs(candidates, 0, len, target, path, res);
            return res;
        }

        private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
            // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
            if (target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = begin; i < len; i++) {
                // 重点理解这里剪枝，前提是候选数组已经有序，
                // 当前元素比target大，后面的元素也比target大。
                if (target - candidates[i] < 0) {
                    break;
                }

                path.addLast(candidates[i]);
                dfs(candidates, i, len, target - candidates[i], path, res);
                path.removeLast();
            }
        }
    }

}
