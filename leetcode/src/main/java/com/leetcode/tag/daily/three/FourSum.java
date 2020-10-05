package com.leetcode.tag.daily.three;

import java.util.*;

/**
 * 18. 四数之和
 */
public class FourSum {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Deque<Integer> stack = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();
            boolean[] used = new boolean[nums.length];

            Arrays.sort(nums);
            back(nums, target, used, 0, stack, result);

            return result;
        }

        /**
         * 超出时间限制
         * <p>
         * 通过start去重.
         * <p>
         * used是排列用法.
         * <p>
         * 排序去重.
         *
         * @param nums
         * @param target
         * @param start
         * @param stack
         * @param result
         */
        private void back(int[] nums, int target, boolean[] used, int start, Deque<Integer> stack, List<List<Integer>> result) {
            if (stack.size() == 4) {
                if (target == 0) {
                    result.add(new ArrayList<>(stack));
                }
                return;
            }
            for (int i = start; i < nums.length; i++) {
                //这个条件厉害.
                //nums[i]是root,且nums[i] == nums[i - 1].
                //如果i-1没有选择,i就是root.
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                stack.push(nums[i]);
                back(nums, target - nums[i], used, i + 1, stack, result);
                stack.pop();
                used[i] = false;
            }
        }
    }

    /**
     * 暴力
     */
    class Solution1 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Set<String> set = new HashSet<>();

            for (int i = 0; i <= nums.length - 4; i++) {
                for (int i1 = i + 1; i1 <= nums.length - 3; i1++) {
                    for (int i2 = i1 + 1; i2 <= nums.length - 2; i2++) {
                        for (int i3 = i2 + 1; i3 <= nums.length - 1; i3++) {
                            String s = nums[i] + "" + nums[i1] + "" + nums[i2] + "" + nums[i3];
                            if (set.contains(s)) {
                                continue;
                            }
                            if (nums[i] + nums[i1] + nums[i2] + nums[i3] == target) {
                                set.add(s);
                                result.add(Arrays.asList(nums[i], nums[i1], nums[i2], nums[i3]));
                            }
                        }
                    }
                }
            }

            return result;
        }
    }
}
