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
}
