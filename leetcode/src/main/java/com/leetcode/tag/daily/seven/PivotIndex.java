package com.leetcode.tag.daily.seven;

import java.util.Arrays;

/**
 * 724. 寻找数组的中心索引
 */
public class PivotIndex {
    /**
     * 方法一：前缀和
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/find-pivot-index/solution/xun-zhao-shu-zu-de-zhong-xin-suo-yin-by-gzjle/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int pivotIndex(int[] nums) {
            //全部元素之和
            int total = Arrays.stream(nums).sum();
            //左侧元素之和为 sum
            int sum = 0;
            for (int i = 0; i < nums.length; ++i) {
                //左右侧元素相等即为 sum = total - nums[i] - sum
                //即 2 × sum + nums[i] = total
                if (2 * sum + nums[i] == total) {
                    return i;
                }
                //左侧元素之和为 sum
                sum += nums[i];
            }
            return -1;
        }
    }

}
