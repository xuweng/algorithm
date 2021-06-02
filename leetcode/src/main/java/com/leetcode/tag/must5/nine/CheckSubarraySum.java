package com.leetcode.tag.must5.nine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    /**
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum/solution/gong-shui-san-xie-tuo-zhan-wei-qiu-fang-1juse/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean checkSubarraySum(int[] nums, int k) {
            int n = nums.length;
            // 前缀和
            int[] sum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
            Set<Integer> set = new HashSet<>();
            // 从 2 开始枚举右端点（根据题目要求，子数组长度至少为 2）
            for (int i = 2; i <= n; i++) {
                // 左端点
                set.add(sum[i - 2] % k);
                if (set.contains(sum[i] % k)) {
                    // 枚举某个右端点 j 时发现存在某个左端点 i 符合要求
                    return true;
                }
            }
            return false;
        }
    }

}
