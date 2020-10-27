package com.leetcode.tag.daily.four;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1365. 有多少小于当前数字的数字
 * <p>
 * 十分钟.十分钟.十分钟
 */
public class SmallerNumbersThanCurrent {
    static class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            int[] result = new int[200];
            List<Integer> list = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
            result[list.get(0)] = 0;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) > list.get(i - 1)) {
                    result[list.get(i)] = i;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = result[nums[i]];
            }
            return nums;
        }
    }

    /**
     * 方法一：暴力
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/solution/you-duo-shao-xiao-yu-dang-qian-shu-zi-de-shu-zi--2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int n = nums.length;
            int[] ret = new int[n];
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int num : nums) {
                    if (num < nums[i]) {
                        cnt++;
                    }
                }
                ret[i] = cnt;
            }
            return ret;
        }
    }

    /**
     * 方法二：快速排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/solution/you-duo-shao-xiao-yu-dang-qian-shu-zi-de-shu-zi--2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int n = nums.length;
            int[][] data = new int[n][2];
            for (int i = 0; i < n; i++) {
                data[i][0] = nums[i];
                data[i][1] = i;
            }
            Arrays.sort(data, Comparator.comparingInt(data2 -> data2[0]));

            int[] ret = new int[n];
            int prev = -1;
            for (int i = 0; i < n; i++) {
                if (prev == -1 || data[i][0] != data[i - 1][0]) {
                    prev = i;
                }
                ret[data[i][1]] = prev;
            }
            return ret;
        }
    }

    /**
     * 方法三：计数排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/solution/you-duo-shao-xiao-yu-dang-qian-shu-zi-de-shu-zi--2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] cnt = new int[101];
            int n = nums.length;
            for (int num : nums) {
                // cnt[i] 表示数字 i 出现的次数
                cnt[num]++;
            }
            for (int i = 1; i <= 100; i++) {
                // 前缀和
                // 对于数字 i 而言，小于它的数目就为 cnt[0...i−1] 的总和
                cnt[i] += cnt[i - 1];
            }
            int[] ret = new int[n];
            for (int i = 0; i < n; i++) {
                ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
            }
            return ret;
        }
    }

}
