package com.leetcode.tag.divide;

/**
 * 调试
 *
 * <p>看答案
 *
 * <p>不用浪费时间
 *
 * <p>面试题40. 最小的k个数
 */
public class LeastNumbers {
  public int[] getLeastNumbers(int[] arr, int k) {
    // 两个参数校验
    if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
      return new int[0];
    }
    divide(arr, 0, arr.length - 1, k);
    int[] result = new int[k];
    System.arraycopy(arr, 0, result, 0, k);
    return result;
  }

  public void divide(int[] arr, int low, int high, int k) {
    // 递归终止条件
    if (low >= high) {
      return;
    }
    int p = patition(arr, low, high);
    if (p == k - 1) {
      return;
    }
    if (p < k - 1) {
      divide(arr, p + 1, high, k);
    } else {
      divide(arr, low, p - 1, k);
    }
  }

  /**
   * 分区函数错误
   *
   * <p>1,2,3,4....
   *
   * <p>2,1
   *
   * <p>小数据规模验证
   *
   * @param arr
   * @param low
   * @param high
   * @return
   */
  public int patition(int[] arr, int low, int high) {
    int p = arr[low];
    // 死循环?
    while (low < high) {
      // 边界判断边界麻烦
      while (low < high && arr[high] >= p) {
        high--;
      }
      if (low < high) {
        arr[low] = arr[high];
      }
      while (low < high && arr[low] < p) {
        low++;
      }
      if (low < high) {
        arr[high] = arr[low];
      }
    }
    arr[low] = p;
    return low;
  }
}
