package com.leetcode.tag.must1.two;

import java.util.HashSet;
import java.util.Set;

/**
 * 287. 寻找重复数
 */
public class FindDuplicate {
    class Solution {
        public int findDuplicate(int[] nums) {
            if (nums == null) {
                return 0;
            }
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (!set.add(num)) {
                    return num;
                }
            }

            return 0;
        }
    }
}
