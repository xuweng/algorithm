package com.leetcode.tag.daily.eight;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 */
public class LongestSubarray {
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int left = 0;
            int right = 0;
            int result = 0;

            while (right < nums.length) {
                int min = getMin(nums, left, right);
                while (min > limit) {
                    left++;

                    min = getMin(nums, left, right);
                }
                result = Math.max(result, right - left + 1);
                right++;
            }

            return result;
        }

        private int getMin(int[] nums, int left, int right) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }

            return max - min;
        }
    }

    /**
     * 方法一：滑动窗口 + 有序集合
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solution/jue-dui-chai-bu-chao-guo-xian-zhi-de-zui-5bki/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int longestSubarray(int[] nums, int limit) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int n = nums.length;
            int left = 0, right = 0;
            int ret = 0;
            while (right < n) {
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
                while (map.lastKey() - map.firstKey() > limit) {
                    map.put(nums[left], map.get(nums[left]) - 1);
                    if (map.get(nums[left]) == 0) {
                        map.remove(nums[left]);
                    }
                    left++;
                }
                ret = Math.max(ret, right - left + 1);
                right++;
            }
            return ret;
        }
    }

    /**
     * 方法二：滑动窗口 + 单调队列
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solution/jue-dui-chai-bu-chao-guo-xian-zhi-de-zui-5bki/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int longestSubarray(int[] nums, int limit) {
            //一个单调递减的队列 queMax 维护最大值
            Deque<Integer> queMax = new LinkedList<>();
            //使用一个单调递增的队列 queMin 维护最小值
            Deque<Integer> queMin = new LinkedList<>();
            int n = nums.length;
            int left = 0, right = 0;
            int ret = 0;
            while (right < n) {
                while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
                    queMax.pollLast();
                }
                while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
                    queMin.pollLast();
                }
                queMax.offerLast(nums[right]);
                queMin.offerLast(nums[right]);
                while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                    if (nums[left] == queMin.peekFirst()) {
                        queMin.pollFirst();
                    }
                    if (nums[left] == queMax.peekFirst()) {
                        queMax.pollFirst();
                    }
                    left++;
                }
                ret = Math.max(ret, right - left + 1);
                right++;
            }
            return ret;
        }
    }

}
