package com.leetcode.tag.binarysearch.two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1658. 将 x 减到 0 的最小操作数
 * <p>
 * 多看。多思考。
 */
public class MinOperations {
    /**
     * 一看到求连续区间和问题，条件反射想到前缀和能否求解。
     * <p>
     * 具体可以把解分成三部分：只取左半部分的和，只取右半部分的和，取左右两部分的和，使用字典存储前缀和，值为步长，直接比较最后的结果即可
     */
    class Solution {
        public int minOperations(int[] nums, int x) {
            //判断总和
            int sum = Arrays.stream(nums).sum();
            if (sum < x) {
                return -1;
            }
            int n = nums.length;
            //左部分和
            Map<Integer, Integer> l_presum = new HashMap<>();
            //右部分和
            Map<Integer, Integer> r_presum = new HashMap<>();
            int l_sum = 0;
            for (int i = 0; i < n; i++) {
                l_sum += nums[i];
                if (l_sum > x) {
                    break;
                }
                l_presum.put(l_sum, i + 1);
            }
            int r_sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                r_sum += nums[i];
                if (r_sum > x) {
                    break;
                }
                r_presum.put(r_sum, n - i);
            }

            int l_steps = l_presum.getOrDefault(x, Integer.MAX_VALUE);
            int r_steps = r_presum.getOrDefault(x, Integer.MAX_VALUE);

            //比较只取左边和只取右边满足条件的步长
            int cur = Math.min(l_steps, r_steps);

            for (int left : l_presum.keySet()) {
                if (r_presum.containsKey(x - left)) {
                    int l = l_presum.get(left);
                    int r = r_presum.get(x - left);
                    if (l + r <= n) {
                        cur = Math.min(cur, l + r);
                    }
                }
            }
            return cur != Integer.MAX_VALUE ? cur : -1;
        }
    }

    /**
     * 滑动窗口
     * <p>
     * 作者：electrobikeman-nanning
     * 链接：https://leetcode-cn.com/problems/minimum-operations-to-reduce-x-to-zero/solution/shi-yong-hua-dong-chuang-kou-zhao-zhong-jian-zui-c/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int minOperations(int[] nums, int x) {
            // 使用滑动窗口找中间最长的片段使得sum(片段)=sum(nums)-x
            int maxPart = -1;
            int sum = Arrays.stream(nums).sum();
            int currentSum = 0;
            int left = 0;
            int right = 0;
            while (left < nums.length) {
                // 右指针移动扩大窗口
                // 左指针移动缩小窗口
                // 如果右边未到尽头，不断先向右探测片段，如果大于目标sum-x则左边移动直到结束
                if (right < nums.length) {
                    currentSum += nums[right++];
                }
                while (currentSum > sum - x && left < nums.length) {
                    currentSum -= nums[left++];
                }
                if (currentSum == sum - x) {
                    maxPart = Math.max(maxPart, right - left);
                }
                if (right == nums.length) {
                    left++;
                }
            }
            return maxPart == -1 ? -1 : nums.length - maxPart;
        }
    }

    /**
     * 双指针，反向考虑
     * <p>
     * 判断从nums两头减数字能否等于x, 相当于判断数组nums是否有子数组和恰好等于数组总和sum-x，并求取最大长度。
     * <p>
     * 用双指针或者滑动窗口遍历数组计算最长和为sum-x的子数组长度。
     * <p>
     * 作者：maxatom
     * 链接：https://leetcode-cn.com/problems/minimum-operations-to-reduce-x-to-zero/solution/shuang-zhi-zhen-fan-xiang-kao-lu-by-maxatom/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int minOperations(int[] nums, int x) {
            int n = nums.length;
            int sum = Arrays.stream(nums).sum();
            if (sum < x) {
                return -1;
            }
            if (sum == x) {
                return n;
            }
            //sum2=区间[l,r]和
            //sum2=rem?
            int l = 0, r = 0, rem = sum - x, sum2 = 0, max = 0;
            while (l < n && r < n) {
                while (r < n && sum2 <= rem) {
                    sum2 += nums[r];
                    r++;
                }
                if (sum2 - nums[r - 1] == rem) {
                    max = Math.max(max, r - 1 - l);
                }
                while (l < r && sum2 > rem) {
                    sum2 -= nums[l];
                    l++;
                }
                if (sum2 == rem) {
                    max = Math.max(max, r - l);
                }
            }
            return max == 0 ? -1 : n - max;
        }

    }

}
