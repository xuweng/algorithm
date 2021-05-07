package com.leetcode.tag.must4;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 */
public class CheckSubarraySum {
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int[] sum = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int s = sum[j + 1] - sum[i];
                    if (s % k == 0) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public class Solution1 {
        public boolean checkSubarraySum(int[] nums, int k) {
            int len = nums.length;
            for (int left = 0; left < len - 1; left++) {
                for (int right = left + 1; right < len; right++) {
                    int sum = 0;
                    for (int i = left; i <= right; i++) {
                        sum += nums[i];
                    }
                    if (sum == k || (k != 0 && sum % k == 0)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public class Solution2 {
        public boolean checkSubarraySum(int[] nums, int k) {
            int len = nums.length;

            // preSum[i] 表示：区间 [0..i) 的前缀和
            int[] preSum = new int[len + 1];
            preSum[0] = 0;
            for (int i = 0; i < len; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }


            for (int left = 0; left < len - 1; left++) {
                for (int right = left + 1; right < len; right++) {
                    int sum = preSum[right + 1] - preSum[left];
                    if (sum == k || (k != 0 && sum % k == 0)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /**
     * 移动指针 移动指针 移动指针
     * <p>
     * 根据求解 1. 两数之和 的经验，我们可以在遍历的过程当中记录已经出现的信息，这样就可以通过一次遍历完成计算
     */
    public class Solution3 {
        public boolean checkSubarraySum(int[] nums, int k) {
            int sum = 0;

            // key：区间 [0..i] 里所有元素的和 % k
            // value：下标 i
            Map<Integer, Integer> map = new HashMap<>();
            // 理解初始化的意义
            map.put(0, -1);
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                sum += nums[i];
                if (k != 0) {
                    sum = sum % k;
                }

                if (map.containsKey(sum)) {
                    // 子数组大小至少为 2
                    if (i - map.get(sum) > 1) {
                        return true;
                    }
                } else {
                    map.put(sum, i);
                }

            }
            return false;
        }
    }
}
