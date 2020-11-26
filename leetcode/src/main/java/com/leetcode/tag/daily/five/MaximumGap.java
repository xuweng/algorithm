package com.leetcode.tag.daily.five;

import java.util.Arrays;

/**
 * 164. 最大间距
 */
public class MaximumGap {
    /**
     * 方法一：基数排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-gap/solution/zui-da-jian-ju-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 最高位优先(Most Significant Digit first)法，简称MSD法
         * <p>
         * 最低位优先(Least Significant Digit first)法，简称LSD法
         *
         * @param nums
         * @return
         */
        public int maximumGap(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return 0;
            }
            long exp = 1;
            int[] buf = new int[n];
            int maxVal = Arrays.stream(nums).max().getAsInt();

            //基数排序
            while (maxVal >= exp) {
                //0到9的桶子
                int[] cnt = new int[10];
                for (int num : nums) {
                    int digit = (num / (int) exp) % 10;
                    cnt[digit]++;
                }
                for (int i = 1; i < 10; i++) {
                    cnt[i] += cnt[i - 1];
                }
                for (int i = n - 1; i >= 0; i--) {
                    int digit = (nums[i] / (int) exp) % 10;
                    buf[cnt[digit] - 1] = nums[i];
                    cnt[digit]--;
                }
                System.arraycopy(buf, 0, nums, 0, n);
                exp *= 10;
            }

            // 相邻最大距离
            int ret = 0;
            for (int i = 1; i < n; i++) {
                ret = Math.max(ret, nums[i] - nums[i - 1]);
            }
            return ret;
        }
    }
}
