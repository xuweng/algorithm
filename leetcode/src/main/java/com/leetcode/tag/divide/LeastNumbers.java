package com.leetcode.tag.divide;

/**
 * 面试题40. 最小的k个数
 */
public class LeastNumbers {
  public int[] getLeastNumbers(int[] arr, int k) {
    // 两个参数校验
    if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
      return new int[0];
    }
    int index = divide(arr, 0, arr.length - 1, k);
    int[] result = new int[k];
    System.arraycopy(arr, 0, result, 0, index + 1);
    return result;
  }

  public int divide(int[] arr, int low, int high, int k) {
    int p = patition(arr, low, high);
    if (p == k - 1) {
      return p;
    } else if (p < k - 1) {
      return divide(arr, p + 1, high, k);
    } else {
      return divide(arr, low, p - 1, k);
    }
  }

  public int patition(int[] arr, int low, int high) {
    int p = arr[low];
    while (low < high) {
      // 边界判断边界麻烦
      while (low < high && arr[high] >= p) {
        high--;
      }
      while (low < high && arr[low] < p) {
        low++;
      }
      if (low != high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
      }
    }
    arr[low] = p;
    return low;
  }
}
