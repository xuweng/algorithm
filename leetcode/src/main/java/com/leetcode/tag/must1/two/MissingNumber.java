package com.leetcode.tag.must1.two;

import java.util.HashSet;
import java.util.Set;

/**
 * 268. 丢失的数字
 */
public class MissingNumber {
    class Solution {
        public int missingNumber(int[] nums) {
            if (nums == null) {
                return 0;
            }
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int n = nums.length;
            for (int i = 0; i <= n; i++) {
                if (!set.contains(i)) {
                    return i;
                }
            }

            return 0;
        }
    }

    class Solution1 {
        public int missingNumber(int[] nums) {
            if (nums == null) {
                return 0;
            }
            int sum = 0;
            int n = nums.length;
            for (int i = 0; i <= n; i++) {
                sum += i;
            }
            for (int num : nums) {
                sum -= num;
            }

            return sum;
        }
    }
}
