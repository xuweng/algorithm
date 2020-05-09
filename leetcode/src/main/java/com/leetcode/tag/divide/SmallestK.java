package com.leetcode.tag.divide;

import java.util.Arrays;
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

  class Solution {
    public int[] smallestK(int[] arr, int k) {
      if (k >= arr.length) {
        return arr;
      }
      if (k == 0) {
        return Arrays.copyOf(arr, k);
      }
      int left = 0;
      int right = arr.length - 1;
      int partition = getPartition(arr, left, right);

      while (partition != k - 1) {
        if (partition > k - 1) {
          right = partition - 1;
        } else {
          left = partition + 1;
        }
        partition = getPartition(arr, left, right);
      }
      return Arrays.copyOf(arr, k);
    }

    public int getPartition(int[] arr, int left, int right) {
      int pivot = arr[left];
      int leftr = left;
      int rightr = right + 1;
      while (leftr < rightr) {
        while (arr[++leftr] < pivot) {
          if (leftr == right) {
            break;
          }
        }
        while (arr[--rightr] > pivot) {
          if (rightr == left) {
            break;
          }
        }
        if (leftr >= rightr) {
          break;
        }
        int temp = arr[leftr];
        arr[leftr] = arr[rightr];
        arr[rightr] = temp;
      }
      int temp = arr[rightr];
      arr[rightr] = pivot;
      arr[left] = temp;
      return rightr;
    }
  }

  class Solution2 {
    public int[] smallestK(int[] arr, int k) {
      if (k == 0 || arr.length == 0) {
        return new int[0];
      }

      int low = 0;
      int high = arr.length - 1;
      while (low < high) {
        int pos = partition(arr, low, high);
        if (pos == k - 1) {
          break;
        } else if (pos < k - 1) {
          low = pos + 1;
        } else {
          high = pos - 1;
        }
      }

      int[] dest = new int[k];
      System.arraycopy(arr, 0, dest, 0, k);
      return dest;
    }

    private int partition(int[] arr, int low, int high) {
      int pivot = arr[low];
      while (low < high) {
        while (low < high && arr[high] >= pivot) {
          high--;
        }
        arr[low] = arr[high];
        while (low < high && arr[low] <= pivot) {
          low++;
        }
        arr[high] = arr[low];
      }
      arr[low] = pivot;
      return low;
    }
  }
}
