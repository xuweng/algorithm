package com.leetcode.tag.daily.four;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1365. 有多少小于当前数字的数字
 * <p>
 * 十分钟.十分钟.十分钟
 */
public class SmallerNumbersThanCurrent {
    static class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            int[] result = new int[200];
            List<Integer> list = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
            result[list.get(0)] = 0;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) > list.get(i - 1)) {
                    result[list.get(i)] = i;
                } else {
                    result[list.get(i)] = result[list.get(i) - 1];
                }
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = result[nums[i]];
            }
            return nums;
        }
    }
}
