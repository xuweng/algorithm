package com.leetcode.tag.binarysearch.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1590. 使数组和能被 P 整除
 */
public class MinSubarray {
    /**
     * 作者：soap88
     * 链接：https://leetcode-cn.com/problems/make-sum-divisible-by-p/solution/javaqiu-qian-zhui-he-by-soap88/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int minSubarray(int[] nums, int p) {
            int n = nums.length;
            long sum = Arrays.stream(nums).asLongStream().sum();
            // 求数组中所有元素和被p除的余数
            long r = sum % p;
            if (r == 0) {
                return 0;
            }

            // 求前缀和
            long[] prefixSum = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            }

            int min = Integer.MAX_VALUE;
            // 哈希表保存上个前缀和的位置，前缀和需要除以p取余数
            Map<Long, Integer> prefixSumMap = new HashMap<>();
            for (int i = 0; i <= n; i++) {
                Integer index = prefixSumMap.get((prefixSum[i] - r) % p);
                if (index != null) {
                    min = Math.min(min, i - index);
                }
                prefixSumMap.merge(prefixSum[i] % p, i, Math::max);
            }
            return (min == Integer.MAX_VALUE || min == n) ? -1 : min;
        }

    }
}
