package com.leetcode.tag.daily;

import java.util.Arrays;

/**
 * 十分钟看题解
 *
 * <p>十分钟看题解
 *
 * <p>十分钟看题解
 *
 * <p>十分钟看题解
 *
 * <p>十分钟看题解
 *
 * <p>搞懂示例
 *
 * <p>搞懂示例
 *
 * <p>搞懂示例
 *
 * <p>搞懂示例
 *
 * <p>搞懂示例
 *
 * <p>搞懂示例
 *
 * <p>3个示例。搞懂示例。
 *
 * <p>3个示例。搞懂示例。
 *
 * <p>3个示例。搞懂示例。
 *
 * <p>3个示例。搞懂示例。
 *
 * <p>1300. 转变数组后最接近目标值的数组和
 */
public class FindBestValue {
  public int findBestValue(int[] arr, int target) {
    return 0;
  }

  /**
   * 方法一：枚举 + 二分查找 思路和算法
   *
   * <p>由于数组 arr 中每个元素值的范围是 [1,10^5]，在可以直接枚举的范围内，
   *
   * <p>因此我们可以对所有可能作为 value 的值进行枚举。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/solution/bian-shu-zu-hou-zui-jie-jin-mu-biao-zhi-de-shu-zu-/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public int findBestValue(int[] arr, int target) {
      Arrays.sort(arr);
      int n = arr.length;
      int[] prefix = new int[n + 1];
      for (int i = 1; i <= n; ++i) {
        prefix[i] = prefix[i - 1] + arr[i - 1];
      }
      int r = arr[n - 1];
      int ans = 0, diff = target;
      for (int i = 1; i <= r; ++i) {
        int index = Arrays.binarySearch(arr, i);
        if (index < 0) {
          index = -index - 1;
        }
        int cur = prefix[index] + (n - index) * i;
        if (Math.abs(cur - target) < diff) {
          ans = i;
          diff = Math.abs(cur - target);
        }
      }
      return ans;
    }
  }
}
