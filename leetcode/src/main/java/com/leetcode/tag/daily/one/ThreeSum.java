package com.leetcode.tag.daily.one;

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
   * 理解重复。理解重复。理解重复。理解重复。理解重复。理解重复。理解重复。理解重复。
   *
   * <p>多个测试用例。多个测试用例。重复数据。重复数据。
   *
   * <p>排序是关键。跳过重复数据。
   *
   * <p>排序：每个元素只会枚举一次
   *
   * <p>重复数据只会枚举一次
   *
   * <p>方法一：排序 + 双指针
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    /**
     * 「不重复」的本质是什么？我们保持三重循环的大框架不变，只需要保证：
     *
     * <p>也就是说，我们枚举的三元组 (a, b, c)满足 a \leq b \leq ca≤b≤c，保证了只有 (a,b,c) 这个顺序会被枚举到，而 (b,a,c)、(c, b, a)
     * 等等这些不会，这样就减少了重复。要实现这一点，我们可以将数组中的元素从小到大进行排序，随后使用普通的三重循环就可以满足上面的要求。
     *
     * @param nums
     * @return
     */
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

  /**
   * 优秀代码
   *
   * <p>优秀代码
   *
   * <p>优秀代码
   *
   * <p>优秀代码
   *
   * <p>优秀代码
   *
   * <p>优秀代码
   *
   * <p>优秀代码
   */
  class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
      if (nums.length < 3) {
        return Collections.emptyList();
      }
      List<List<Integer>> res = new ArrayList<>();
      int minValue = Integer.MAX_VALUE;
      int maxValue = Integer.MIN_VALUE;
      int negSize = 0;
      int posSize = 0;
      int zeroSize = 0;
      for (int v : nums) {
        if (v < minValue) {
          minValue = v;
        }
        if (v > maxValue) {
          maxValue = v;
        }
        if (v > 0) {
          posSize++;
        } else if (v < 0) {
          negSize++;
        } else {
          zeroSize++;
        }
      }
      if (zeroSize >= 3) {
        res.add(Arrays.asList(0, 0, 0));
      }
      if (negSize == 0 || posSize == 0) {
        return res;
      }
      if (minValue * 2 + maxValue > 0) {
        maxValue = -minValue * 2;
      } else if (maxValue * 2 + minValue < 0) {
        minValue = -maxValue * 2;
      }

      int[] map = new int[maxValue - minValue + 1];
      int[] negs = new int[negSize];
      int[] poses = new int[posSize];
      negSize = 0;
      posSize = 0;
      for (int v : nums) {
        if (v >= minValue && v <= maxValue) {
          if (map[v - minValue]++ == 0) {
            if (v > 0) {
              poses[posSize++] = v;
            } else if (v < 0) {
              negs[negSize++] = v;
            }
          }
        }
      }
      Arrays.sort(poses, 0, posSize);
      Arrays.sort(negs, 0, negSize);
      int basej = 0;
      for (int i = negSize - 1; i >= 0; i--) {
        int nv = negs[i];
        int minp = (-nv) >>> 1;
        while (basej < posSize && poses[basej] < minp) {
          basej++;
        }
        for (int j = basej; j < posSize; j++) {
          int pv = poses[j];
          int cv = 0 - nv - pv;
          if (cv >= nv && cv <= pv) {
            if (cv == nv) {
              if (map[nv - minValue] > 1) {
                res.add(Arrays.asList(nv, nv, pv));
              }
            } else if (cv == pv) {
              if (map[pv - minValue] > 1) {
                res.add(Arrays.asList(nv, pv, pv));
              }
            } else {
              if (map[cv - minValue] > 0) {
                res.add(Arrays.asList(nv, cv, pv));
              }
            }
          } else if (cv < nv) {
            break;
          }
        }
      }
      return res;
    }
  }
}
