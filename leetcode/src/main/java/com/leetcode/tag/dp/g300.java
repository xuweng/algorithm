package com.leetcode.tag.dp;

/**
 * 官方:300. 最长上升子序列
 */
public class g300 {
  /**
   * 方法二：贪心 + 二分查找
   *
   * <p>考虑一个简单的贪心，如果我们要使上升子序列尽可能的长，则我们需要让序列上升得尽可能慢，
   *
   * <p>因此我们希望每次在上升子序列最后加上的那个数尽可能的小。
   *
   * <p>最后整个算法流程为：
   *
   * <p>设当前已求出的最长上升子序列的长度为 len（初始时为 11），从前往后遍历数组nums，在遍历到 nums[i] 时：
   *
   * <p>如果 nums[i] > d[len] ，则直接加入到 dd 数组末尾，并更新len=len+1；
   *
   * <p>否则，在 dd 数组中二分查找，找到第一个比 nums[i] 小的数 d[k] ，并更新d[k+1]=nums[i]。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return 1;
    }
    int[] max = new int[nums.length];
    max[0] = nums[0];
    int length = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > max[length - 1]) {
        max[length++] = nums[i];
      } else {
        int index = binarySearch(max, nums[i], 0, length - 1);
        max[index] = nums[i];
      }
    }

    return length;
  }

  /**
   * 二分查找
   *
   * <p>画图和举例子分析
   *
   * <p>找到第一个比 value 小的下标
   *
   * @param max
   * @param value
   * @param start
   * @param end
   * @return 第一个比 value 小的下标
   */
  public int binarySearch(int[] max, int value, int start, int end) {
    int low = start;
    int high = end;

    while (low < high) {
      int mid = (low + high) >> 1;
      if (value > max[mid]) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    return low;
  }
}
