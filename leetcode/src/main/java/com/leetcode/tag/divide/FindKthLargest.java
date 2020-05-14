package com.leetcode.tag.divide;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 215. 数组中的第K个最大元素
 */
public class FindKthLargest {
  public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
      return 0;
    }
    Queue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
      queue.offer(nums[i]);
    }
    for (int i = k; i < nums.length; i++) {
      if (nums[i] > queue.peek()) {
        queue.poll();
        queue.offer(nums[i]);
      }
    }
    return queue.peek();
  }
}
