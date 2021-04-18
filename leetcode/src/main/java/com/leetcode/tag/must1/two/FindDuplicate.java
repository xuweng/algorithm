package com.leetcode.tag.must1.two;

import java.util.HashSet;
import java.util.Set;

/**
 * 287. 寻找重复数
 * <p>
 * 移动后比较 if开始
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

    class Solution1 {
        public int findDuplicate(int[] nums) {
            if (nums == null) {
                return 0;
            }
            int left = 1, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int count = 0;
                for (int num : nums) {
                    if (num <= mid) {
                        count++;
                    }
                }
                if (count > mid) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

            }

            return left;
        }
    }
}
