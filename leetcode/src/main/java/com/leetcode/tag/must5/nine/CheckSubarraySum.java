package com.leetcode.tag.must5.nine;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 */
public class CheckSubarraySum {
    public class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int sum = 0;
            // 区间和:sum[j] - sum[i]
            // (sum[j] - sum[i]) % k = 0
            // sum[j] % k = sum[i] % k
            // 先把sum[i] % k放入map，查询sum[j] % k是否在map
            // key：区间 [0..i] 里所有元素的和 % k
            // value：下标 i
            Map<Integer, Integer> map = new HashMap<>();
            int len = nums.length;
            // 必须
            // [1,1] 1
            // sum[1]=[0,1] sum[1]%k==0 1-(-1)=2
            map.put(0, -1);
            for (int i = 0; i < len; i++) {
                sum += nums[i];
                if (map.containsKey(sum % k)) {
                    // 子数组大小至少为 2
                    if (i - map.get(sum % k) > 1) {
                        return true;
                    }
                } else {
                    map.put(sum % k, i);
                }

            }
            return false;
        }
    }
}
