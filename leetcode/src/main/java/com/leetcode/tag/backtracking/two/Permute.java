package com.leetcode.tag.backtracking.two;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
