package com.leetcode.tag.daily;

import java.util.Arrays;

/**
 * 推导过程
 *
 * <p>推导过程
 *
 * <p>算法证明过程
 *
 * <p>4. 寻找两个正序数组的中位数
 *
 * <p>有序数组
 *
 * <p>有序数组
 *
 * <p>有序数组
 *
 * <p>有序数组
 *
 * <p>有序数组
 *
 * <p>有序数组
 *
 * <p>二分查找
 *
 * <p>二分查找
 *
 * <p>证明算法正确性
 *
 * <p>如果对时间复杂度的要求有 log，通常都需要用到二分查找，这道题也可以通过二分查找实现。
 */
public class FindMedianSortedArrays {
  /** 暴力法 */
  class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int[] nums3 = concat(nums1, nums2);
      if (nums3.length == 1) {
        return nums3[0];
      }
      Arrays.sort(nums3);

      int index = nums3.length >> 1;
      if (nums3.length % 2 == 0) {
        return (nums3[index] + nums3[index - 1]) / 2.0;
      } else {
        return nums3[index];
      }
    }

    public int[] concat(int[] a, int[] b) {
      int[] c = new int[a.length + b.length];
      System.arraycopy(a, 0, c, 0, a.length);
      System.arraycopy(b, 0, c, a.length, b.length);
      return c;
    }
  }

  /** 归并排序 */
  static class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int[] left = new int[nums1.length + 1];
      int[] right = new int[nums2.length + 1];

      left[left.length - 1] = Integer.MAX_VALUE;
      right[right.length - 1] = Integer.MAX_VALUE;

      System.arraycopy(nums1, 0, left, 0, nums1.length);
      System.arraycopy(nums2, 0, right, 0, nums2.length);

      int length = nums1.length + nums2.length;
      int[] result = new int[length];
      int leftIndex = 0, rightIndex = 0;
      for (int i = 0; i <= length / 2; i++) {
        if (left[leftIndex] < right[rightIndex]) {
          result[i] = left[leftIndex];
          leftIndex++;
        } else {
          result[i] = right[rightIndex];
          rightIndex++;
        }
      }
      if (length % 2 == 0) {
        return (result[length / 2 - 1] + result[length / 2]) / 2.0;
      } else {
        return result[length / 2];
      }
    }
  }

  /**
   * 这道题可以转化成寻找两个有序数组中的第 k 小的数，其中 k 为 (m+n)/2 或 (m+n)/2+1。
   *
   * <p>二分查找:每次排除一半
   *
   * <p>每次排除一半
   *
   * <p>要找第 k 小数，我们可以每次循环排除掉 k/2 个数
   *
   * <p>https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int length1 = nums1.length, length2 = nums2.length;
      int totalLength = length1 + length2;
      if (totalLength % 2 == 1) {
        int midIndex = totalLength / 2;
        return getKthElement(nums1, nums2, midIndex + 1);
      } else {
        int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
        return (getKthElement(nums1, nums2, midIndex1 + 1)
                + getKthElement(nums1, nums2, midIndex2 + 1))
            / 2.0;
      }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
      /*
       * 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较 这里的 "/" 表示整除
       * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个 nums2 中小于等于 pivot2 的元素有 nums2[0 ..
       * k/2-2] 共计 k/2-1 个 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1)
       * <= k-2 个 这样 pivot 本身最大也只能是第 k-1 小的元素 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k
       * 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k
       * 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
       */
      int length1 = nums1.length, length2 = nums2.length;
      int index1 = 0, index2 = 0;

      while (true) {
        // 边界情况
        if (index1 == length1) {
          return nums2[index2 + k - 1];
        }
        if (index2 == length2) {
          return nums1[index1 + k - 1];
        }
        if (k == 1) {
          return Math.min(nums1[index1], nums2[index2]);
        }

        // 正常情况
        int half = k / 2;
        int newIndex1 = Math.min(index1 + half, length1) - 1;
        int newIndex2 = Math.min(index2 + half, length2) - 1;
        int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
        if (pivot1 <= pivot2) {
          k -= (newIndex1 - index1 + 1);
          index1 = newIndex1 + 1;
        } else {
          k -= (newIndex2 - index2 + 1);
          index2 = newIndex2 + 1;
        }
      }
    }
  }
}
