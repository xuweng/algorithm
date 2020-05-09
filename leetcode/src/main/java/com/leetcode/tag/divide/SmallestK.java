package com.leetcode.tag.divide;

import java.util.PriorityQueue;

/**
 * 划分2份?
 *
 * <p>面试题 17.14. 最小K个数
 */
public class SmallestK {
  public int[] smallestK(int[] arr, int k) {
    if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
      return new int[0];
    }
    // 初始大小为k的大顶堆
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
    for (int i = 0; i < k; i++) {
      maxHeap.offer(arr[i]);
    }
    for (int i = k; i < arr.length; i++) {
      if (maxHeap.peek() > arr[i]) {
        maxHeap.poll();
        maxHeap.offer(arr[i]);
      }
    }

    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = maxHeap.poll();
    }
    return result;
  }
}
