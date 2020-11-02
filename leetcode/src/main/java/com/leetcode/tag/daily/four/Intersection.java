package com.leetcode.tag.daily.four;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 349. 两个数组的交集
 */
public class Intersection {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
                return new int[0];
            }
            Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

            List<Integer> result = set1.stream().filter(set2::contains).collect(Collectors.toList());

            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
