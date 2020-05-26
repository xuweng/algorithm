package com.leetcode.tag.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 287. 寻找重复数
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
public class FindDuplicateNumber {
  public int findDuplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
        return nums[i];
      }
    }
    return 0;
  }

  /**
   * 定义 cnt[i] 表示nums[] 数组中小于等于 i 的数有多少个
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    /**
     * 二分法还可以用于确定一个有范围的整数
     *
     * <p>查找的数是一个整数，并且给出了这个整数的范围（在 1 和 n 之间，包括 1 和 n），并且给出了一些限制，
     *
     * <p>于是可以使用二分查找法定位在一个区间里的整数；
     *
     * <p>二分法的思路是先猜一个数（有效范围 [left, right]里的中间数 mid），
     *
     * <p>然后统计原始数组中小于等于这个中间数的元素的个数 cnt，如果 cnt 严格大于
     *
     * <p>mid，（注意我加了着重号的部分「小于等于」、「严格大于」）。根据抽屉原理，重复元素就在区间 [left, mid] 里；
     *
     * <p>作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * <p>数字都在 1 到 n 之间（包括 1 和 n）
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
      int n = nums.length;
      // 最小值
      int l = 1;
      // 最大值
      int r = n - 1;
      int ans = -1;
      while (l <= r) {
        int mid = (l + r) >> 1;
        // 统计小于等于mid的个数
        int cnt = 0;
        for (int num : nums) {
          if (num <= mid) {
            cnt++;
          }
        }
        if (cnt <= mid) {
          // 重复数字划分到右部分
          l = mid + 1;
        } else {
          // 重复数字划分到左部分
          r = mid - 1;
          ans = mid;
        }
      }
      return ans;
    }
  }

  class Solution1 {
    public int findDuplicate(int[] nums) {
      int n = nums.length, ans = 0;
      int bitMax = 31;
      while (((n - 1) >> bitMax) == 0) {
        bitMax -= 1;
      }
      for (int bit = 0; bit <= bitMax; ++bit) {
        int x = 0, y = 0;
        for (int i = 0; i < n; ++i) {
          if ((nums[i] & (1 << bit)) != 0) {
            x += 1;
          }
          if (i >= 1 && ((i & (1 << bit)) != 0)) {
            y += 1;
          }
        }
        if (x > y) {
          ans |= 1 << bit;
        }
      }
      return ans;
    }
  }

  class Solution2 {
    /**
     * 使用「快慢指针」来完成，不过这种做法太有技巧性了，不是通用的做法
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
      int slow = 0, fast = 0;
      slow = nums[slow];
      fast = nums[nums[fast]];
      while (slow != fast) {
        slow = nums[slow];
        fast = nums[nums[fast]];
      }
      slow = 0;
      while (slow != fast) {
        slow = nums[slow];
        fast = nums[fast];
      }
      return slow;
    }
  }

  public int findDuplicate1(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
      if (map.get(nums[i]) > 1) {
        j = i;
        break;
      }
    }

    return nums[j];
  }
}
