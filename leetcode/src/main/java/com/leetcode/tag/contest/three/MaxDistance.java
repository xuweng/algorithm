package com.leetcode.tag.contest.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 5751. 下标对中的最大距离
 */
public class MaxDistance {
    class Solution {
        public int maxDistance(int[] nums1, int[] nums2) {
            int result = 0;
            for (int i = 0; i < nums1.length; i++) {
                for (int j = i; j < nums2.length; j++) {
                    if (nums1[i] <= nums2[j]) {
                        result = Math.max(result, j - i);
                    }
                }
            }

            return result;
        }
    }

    class Solution1 {
        public int maxDistance(int[] nums1, int[] nums2) {
            int result = 0;
            Map<Integer, List<Integer>> map = new HashMap<>();
            Map<Integer, List<Integer>> map1 = new HashMap<>();

            for (int i = 0; i < nums1.length; i++) {
                map.computeIfAbsent(nums1[i], v -> new ArrayList<>()).add(i);
            }

            for (int i = 0; i < nums2.length; i++) {
                map1.computeIfAbsent(nums2[i], v -> new ArrayList<>()).add(i);
            }

            return result;
        }
    }
}
