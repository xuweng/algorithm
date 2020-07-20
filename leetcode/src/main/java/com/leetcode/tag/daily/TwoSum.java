package com.leetcode.tag.daily;

/**
 * 167. 两数之和 II - 输入有序数组
 */
public class TwoSum {
  /**
   * 升序排列 的有序数组
   *
   * <p>每次排除一个数据
   *
   * <p>不是每次排除一半
   */
  class Solution {
    public int[] twoSum(int[] numbers, int target) {
      int low = 0;
      int high = numbers.length - 1;

      while (low <= high) {
        if (numbers[low] + numbers[high] == target) {
          return new int[]{low + 1, high + 1};
        } else if (numbers[low] + numbers[high] < target) {
          low++;
        } else {
          high--;
        }
      }

      return new int[0];
    }
  }

  /**
   * 方法一：二分查找
   *
   * <p>可以首先固定第一个数，然后寻找第二个数，第二个数等于目标值减去第一个数的差
   *
   * <p>利用数组的有序性质，可以通过二分查找的方法寻找第二个数。
   *
   * <p>为了避免重复寻找，在寻找第二个数时，只在第一个数的右侧寻找。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/liang-shu-zhi-he-ii-shu-ru-you-xu-shu-zu-by-leet-2/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
      for (int i = 0; i < numbers.length; ++i) {
        // 固定i
        int low = i + 1, high = numbers.length - 1;
        while (low <= high) {
          int mid = (high - low) / 2 + low;
          if (numbers[mid] == target - numbers[i]) {
            return new int[]{i + 1, mid + 1};
          } else if (numbers[mid] > target - numbers[i]) {
            high = mid - 1;
          } else {
            low = mid + 1;
          }
        }
      }
      return new int[]{-1, -1};
    }
  }
}
