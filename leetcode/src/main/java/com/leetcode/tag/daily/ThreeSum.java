package com.leetcode.tag.daily;

import java.util.*;

/**
 * 15. 三数之和
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 */
public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length < 3) {
      return result;
    }
    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      set.add(i);
    }
    Set<Integer> maxSet = new HashSet<>();
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int third = -nums[i] - nums[j];
        int max = Math.max(third, Math.max(nums[i], nums[j]));
        if (maxSet.contains(max)) {
          continue;
        }
        if (set.contains(third)) {
          maxSet.add(max);
          List<Integer> list = new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[j]);
          list.add(third);
          result.add(list);
          break;
        }
      }
    }

    return result;
  }

  /**
   * 方法一：排序 + 双指针
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      int n = nums.length;
      Arrays.sort(nums);
      List<List<Integer>> ans = new ArrayList<>();
      // 枚举 a
      for (int first = 0; first < n; ++first) {
        // 需要和上一次枚举的数不相同
        if (first > 0 && nums[first] == nums[first - 1]) {
          continue;
        }
        // c 对应的指针初始指向数组的最右端
        int third = n - 1;
        int target = -nums[first];
        // 枚举 b
        for (int second = first + 1; second < n; ++second) {
          // 需要和上一次枚举的数不相同
          if (second > first + 1 && nums[second] == nums[second - 1]) {
            continue;
          }
          // 需要保证 b 的指针在 c 的指针的左侧
          while (second < third && nums[second] + nums[third] > target) {
            --third;
          }
          // 如果指针重合，随着 b 后续的增加
          // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
          if (second == third) {
            break;
          }
          if (nums[second] + nums[third] == target) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[first]);
            list.add(nums[second]);
            list.add(nums[third]);
            ans.add(list);
          }
        }
      }
      return ans;
    }
  }
}
