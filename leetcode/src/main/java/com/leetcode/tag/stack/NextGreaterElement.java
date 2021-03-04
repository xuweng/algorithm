package com.leetcode.tag.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * 496. 下一个更大元素 I
 */
public class NextGreaterElement {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0) {
                return nums1;
            }
            for (int i = 0; i < nums2.length; i++) {
                map.put(nums2[i], i);
            }
            int[] result = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                result[i] = get(nums2, nums1[i]);
            }

            return result;
        }

        private int get(int[] nums2, int value) {
            int index = map.get(value);
            for (int i = index + 1; i < nums2.length; i++) {
                if (nums2[i] > value) {
                    return nums2[i];
                }
            }

            return -1;
        }
    }
}
