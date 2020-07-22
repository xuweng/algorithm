package com.leetcode.tag.daily;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 */
public class MinArray {
  class Solution {
    public int minArray(int[] numbers) {
      int i = 0, j = numbers.length - 1;
      while (i < j) {
        int m = (i + j) / 2;
        // 和j比较,不是和i比较
        if (numbers[m] > numbers[j]) {
          i = m + 1;
        } else if (numbers[m] < numbers[j]) {
          j = m;
        } else {
          j--;
        }
      }
      return numbers[i];
    }
  }

  /**
   * 官方题解很详细
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-by-leetcode-s/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    public int minArray(int[] numbers) {
      int low = 0;
      int high = numbers.length - 1;
      while (low < high) {
        int pivot = low + (high - low) / 2;
        if (numbers[pivot] < numbers[high]) {
          high = pivot;
        } else if (numbers[pivot] > numbers[high]) {
          low = pivot + 1;
        } else {
          // 相等只能排除一个元素
          high -= 1;
        }
      }
      return numbers[low];
    }
  }
}
