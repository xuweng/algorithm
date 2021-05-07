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
     * 使用sum表示前缀和根据题目要求，(sum[j] - sum[i]) % k = 0
     * <p>
     * sum[j] % k = sum[i] % k
     * <p>
     * 子数组[i, j - 1]的和sum[j] - sum[i]是k的n倍，那么sum[j] % k = sum[i] % k
     * <p>
     * 根据求解 1. 两数之和 的经验，我们可以在遍历的过程当中记录已经出现的信息，这样就可以通过一次遍历完成计算
     */
    public class Solution3 {
        public boolean checkSubarraySum(int[] nums, int k) {
            int sum = 0;

            // (sum[j] - sum[i]) % k = 0
            // sum[j] % k = sum[i] % k
            // 先把sum[i] % k放入map，查询sum[j] % k是否在map
            // key：区间 [0..i] 里所有元素的和 % k
            // value：下标 i
            Map<Integer, Integer> map = new HashMap<>();
            int len = nums.length;
            // 必须
            // sum[i]=[0,i] sum[i]%k==0 i-(-1)=2
            map.put(0, -1);
            for (int i = 0; i < len; i++) {
                sum += nums[i];
                sum = sum % k;

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

    class Solution4 {
        public boolean checkSubarraySum(int[] nums, int k) {
            int sum = 0;
            // 键为 preSum % k, 值为索引，当然要特殊处理k == 0的情况
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                int temp = k == 0 ? sum : sum % k;
                // 出现相同的键，如果子数组长度少于2， 不需要更新值。
                if (map.containsKey(temp)) {
                    // 子数组要求长度至少为2。
                    if (i - map.get(temp) > 1) {
                        return true;
                    }
                    continue;
                }
                map.put(temp, i);
            }
            return false;
        }
    }
}
