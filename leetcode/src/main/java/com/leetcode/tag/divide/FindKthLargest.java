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

  /**
   * 修改基础代码模板
   *
   * <p>修改快排的代码模板
   *
   * <p>修改建堆的代码模板
   */
  class Solution {
    public int findKthLargest(int[] nums, int k) {
      return quickSort(nums, 0, nums.length - 1, k);
    }

    int quickSort(int[] nums, int l, int r, int k) {
      if (l >= r) {
        return nums[l];
      }
      int i = l - 1, j = r + 1;
      int mid = nums[l + r >> 1];
      while (i < j) {
        do {
          i++;
        } while (nums[i] < mid);
        do {
          j--;
        } while (nums[j] > mid);
        if (i < j) {
          swap(nums, i, j);
        }
      }
      if (r - j >= k) {
        return quickSort(nums, j + 1, r, k);
      }
      return quickSort(nums, l, j, k - (r - j));
    }

    void swap(int[] nums, int l, int r) {
      int tmp = nums[l];
      nums[l] = nums[r];
      nums[r] = tmp;
    }
  }

  class Solution1 {

    public int findKthLargest(int[] nums, int k) {
      // 前K个元素原地建小顶堆
      buildHeap(nums, k);
      // 遍历剩下的元素
      for (int i = k; i < nums.length; i++) {
        if (nums[i] < nums[0]) {
          continue;
        }
        swap(nums, i, 0);
        heapify(nums, k, 0);
      }
      return nums[0];
    }

    /**
     * 堆化函数 父节点下标i，左右子节点的下标分别为 2*i+1 和 2*i+2
     */
    public void heapify(int[] a, int k, int i) {
      // 临时变量 minPos 用于存储最小值的下标，先假设父节点最小
      int minPos = i;
      while (true) {
        // 和左子节点比较
        if (i * 2 + 1 < k && a[i * 2 + 1] < a[i]) {
          minPos = i * 2 + 1;
        }
        if (i * 2 + 2 < k && a[i * 2 + 2] < a[minPos]) {
          minPos = i * 2 + 2;
        }
        // 如果 minPos没有发生变化，说明父节点已经是最小了，直接跳出
        if (minPos == i) {
          break;
        }
        // 交换
        swap(a, i, minPos);
        i = minPos;
      }
    }

    /* 建堆函数 */
    public void buildHeap(int[] a, int k) {
      for (int i = k / 2 - 1; i >= 0; i--) {
        heapify(a, k, i);
      }
    }

    public void swap(int[] a, int n, int m) {
      int tmp = a[n];
      a[n] = a[m];
      a[m] = tmp;
    }
  }
}
