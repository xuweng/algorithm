package com.leetcode.tag.must1.three;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 496. 下一个更大元素 I
 */
public class NextGreaterElement {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Deque<Integer> deque = new LinkedList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = nums2.length - 1; i >= 0; i--) {
                while (!deque.isEmpty() && deque.peekLast() <= nums2[i]) {
                    deque.pollLast();
                }
                map.put(nums2[i], deque.isEmpty() ? -1 : deque.peekLast());
                deque.offerLast(nums2[i]);
            }
            int[] result = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                result[i] = map.get(nums1[i]);
            }

            return result;
        }
    }
}
