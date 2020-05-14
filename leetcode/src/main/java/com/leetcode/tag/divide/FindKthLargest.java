package com.leetcode.tag.divide;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 代码模板太好用
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>215. 数组中的第K个最大元素
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

  public int findKthLargest1(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
      return 0;
    }

    return divide(nums, 0, nums.length - 1, k);
  }

  private int divide(int[] nums, int low, int high, int k) {
    if (low > high) {
      return 0;
    }
    int p = patition(nums, low, high);
    if (nums.length - k == p) {
      return nums[p];
    } else if (nums.length - k < p) {
      return divide(nums, low, p - 1, k);
    } else {
      return divide(nums, p + 1, high, k);
    }
  }

  private int patition(int[] nums, int low, int high) {
    int p = nums[low];
    while (low < high) {
      while (low < high && nums[high] >= p) {
        high--;
      }
      nums[low] = nums[high];
      while (low < high && nums[low] < p) {
        low++;
      }
      nums[high] = nums[low];
    }
    nums[low] = p;
    return low;
  }
}
