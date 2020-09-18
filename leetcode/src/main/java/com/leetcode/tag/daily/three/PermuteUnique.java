package com.leetcode.tag.daily.three;

import java.util.*;

/**
 * 47. 全排列 II
 * <p>
 * 几乎每次去重都错
 */
public class PermuteUnique {
    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);

            boolean[] used = new boolean[nums.length];
            Deque<Integer> stack = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();

            back(nums, used, stack, result);

            return result;
        }

        /**
         * 脑里执行一遍示例
         * <p>
         * begin是递归层次.递归层次.递归层次
         *
         * @param nums
         * @param used
         * @param stack
         * @param result
         */
        private void back(int[] nums, boolean[] used, Deque<Integer> stack, List<List<Integer>> result) {
            if (stack.size() == nums.length) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                //没有去重
                //就差最后一个条件
                //i > 0 && nums[i] == nums[i - 1].必须的
                if ((used[i]) || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                    continue;
                }
                used[i] = true;
                stack.push(nums[i]);
                back(nums, used, stack, result);
                used[i] = false;
                stack.pop();
            }
        }
    }

    /**
     * 方法一：搜索回溯
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/permutations-ii/solution/quan-pai-lie-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        boolean[] vis;

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> perm = new ArrayList<>();
            vis = new boolean[nums.length];
            Arrays.sort(nums);

            backtrack(nums, ans, 0, perm);

            return ans;
        }

        public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
            if (idx == nums.length) {
                ans.add(new ArrayList<>(perm));
                return;
            }
            for (int i = 0; i < nums.length; ++i) {
                if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                    continue;
                }
                perm.add(nums[i]);
                vis[i] = true;
                backtrack(nums, ans, idx + 1, perm);
                vis[i] = false;
                perm.remove(idx);
            }
        }
    }

}
