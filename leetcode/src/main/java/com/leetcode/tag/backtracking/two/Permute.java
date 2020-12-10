package com.leetcode.tag.backtracking.two;

import java.util.*;

/**
 * 46. 全排列
 */
public class Permute {
    static class Solution {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            if (nums == null || nums.length == 0) {
                return result;
            }

            back(nums);
            return result;
        }

        private void back(int[] nums) {
            if (nums.length == set.size()) {
                result.add(new ArrayList<>(set));
                return;
            }
            for (int num : nums) {
                if (set.contains(num)) {
                    continue;
                }
                set.add(num);
                back(nums);
                set.remove(num);
            }
        }
    }

    class Solution1 {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        boolean[] used;

        public List<List<Integer>> permute(int[] nums) {
            used = new boolean[nums.length];

            back(nums);

            return result;
        }

        private void back(int[] nums) {
            if (nums.length == deque.size()) {
                result.add(new ArrayList<>(deque));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                deque.push(nums[i]);
                back(nums);
                deque.pop();
                used[i] = false;
            }
        }
    }
}
