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
     * <p>
     * 最朴素的方法是使用四重循环枚举所有的四元组，然后使用哈希表进行去重操作，得到不包含重复四元组的最终答案
     */
    class Solution1 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Set<String> set = new HashSet<>();

            for (int i = 0; i <= nums.length - 4; i++) {
                for (int i1 = i + 1; i1 <= nums.length - 3; i1++) {
                    for (int i2 = i1 + 1; i2 <= nums.length - 2; i2++) {
                        for (int i3 = i2 + 1; i3 <= nums.length - 1; i3++) {
                            if (nums[i] + nums[i1] + nums[i2] + nums[i3] == target) {
                                int[] array = {nums[i], nums[i1], nums[i2], nums[i3]};
                                Arrays.sort(array);

                                String s = array[0] + "" + array[1] + "" + array[2] + "" + array[3];
                                if (!set.contains(s)) {
                                    result.add(Arrays.asList(nums[i], nums[i1], nums[i2], nums[i3]));
                                }
                                set.add(s);
                            }
                        }
                    }
                }
            }

            return result;
        }
    }

    /**
     * 方法一：排序 + 双指针
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/4sum/solution/si-shu-zhi-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> quadruplets = new ArrayList<>();
            if (nums == null || nums.length < 4) {
                return quadruplets;
            }
            Arrays.sort(nums);
            int length = nums.length;
            for (int i = 0; i < length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                for (int j = i + 1; j < length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                        continue;
                    }
                    int left = j + 1, right = length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            left++;
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return quadruplets;
        }
    }

}
